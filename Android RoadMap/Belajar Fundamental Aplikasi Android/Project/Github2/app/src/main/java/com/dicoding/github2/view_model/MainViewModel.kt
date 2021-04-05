package com.dicoding.github2.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dicoding.github2.BuildConfig
import com.dicoding.github2.model.User
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject

@Suppress("NAME_SHADOWING")
class MainViewModel : ViewModel() {
    val listuser = MutableLiveData<ArrayList<User>>()
    var detailuser = MutableLiveData<User>()

    fun getUser(): LiveData<ArrayList<User>> {
        return listuser
    }

    fun getdetailUser(): LiveData<User> {
        return detailuser
    }


    fun getAllUser() {
        val listitem = ArrayList<User>()

        val client = AsyncHttpClient()
        val url = "https://api.github.com/users"

        client.addHeader("Authorization", BuildConfig.GITHUB_TOKEN)
        client.addHeader("User-Agent", "request")
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                try {
                    val jsonArray = JSONArray(result)

                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val username = jsonObject.getString("login")
                        val avatar = jsonObject.getString("avatar_url")
                        val user = User()
                        user.Username = username
                        user.Avatar = avatar
                        listitem.add(user)
                    }
                    listuser.postValue(listitem)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Log.d("Error", errorMessage)
            }
        })
    }

    fun finduser(user: String) {
        val listfinduser = ArrayList<User>()

        val client = AsyncHttpClient()
        val url = "https://api.github.com/search/users?q=$user"

        client.addHeader("Authorization", BuildConfig.GITHUB_TOKEN)
        client.addHeader("User-Agent", "request")
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {

                val result = String(responseBody)
                try {
                    val responseObjects = JSONObject(result)
                    val items = responseObjects.getJSONArray("items")
                    listfinduser.clear()
                    for (i in 0 until items.length()) {
                        val item = items.getJSONObject(i)
                        val username = item.getString("login")
                        val avatar = item.getString("avatar_url")
                        val users = User()
                        users.Username = username
                        users.Avatar = avatar
                        listfinduser.add(users)
                    }
                    listuser.postValue(listfinduser)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Log.d("Error", errorMessage)
            }
        })
    }

    fun getdatauser(Username: String) {
        val client = AsyncHttpClient()
        val url = "https://api.github.com/users/$Username"
        client.addHeader("Authorization", BuildConfig.GITHUB_TOKEN)
        client.addHeader("User-Agent", "request")
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                /*showLoading(false)*/
                val result = String(responseBody)
                try {
                    val responseObjects = JSONObject(result)
                    val username = responseObjects.getString("login")
                    val avatar = responseObjects.getString("avatar_url")
                    val followers = responseObjects.getString("followers")
                    val following = responseObjects.getString("following")
                    var name = responseObjects.getString("name")
                    var company = responseObjects.getString("company")
                    var location = responseObjects.getString("location")
                    val repository = responseObjects.getString("public_repos")

                    if (name == "null") name = ""
                    if (location == "null") location = "-"
                    if (company == "null") company = "-"

                    detailuser.postValue(
                        User(
                            name,
                            username,
                            location,
                            repository.toInt(),
                            company,
                            followers.toInt(),
                            following.toInt(),
                            avatar
                        )
                    )

                } catch (e: Exception) {
                    e.printStackTrace()
                }


            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
                Log.d("Error", errorMessage)
            }
        })
    }

    fun getfollow(Username: String, state: Int) {
        var url = ""
        if (state == 1){
            url = "https://api.github.com/users/$Username/following"
        }else{
            url = "https://api.github.com/users/$Username/followers"
        }
        val listUser = ArrayList<User>()
        val client = AsyncHttpClient()
        client.addHeader("Authorization", BuildConfig.GITHUB_TOKEN)
        client.addHeader("User-Agent", "request")
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray
            ) {
                val result = String(responseBody)
                try {
                    val responseObjects = JSONArray(result)

                    for (i in 0 until responseObjects.length()) {
                        val items = responseObjects.getJSONObject(i)
                        val username = items.getString("login")
                        val avatar = items.getString("avatar_url")
                        val user = User()
                        user.Username = username
                        user.Avatar = avatar
                        listUser.add(user)
                    }
                    listuser.postValue(listUser)

                } catch (e: Exception) {
                    e.printStackTrace()
                }


            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<Header>,
                responseBody: ByteArray,
                error: Throwable
            ) {
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error.message}"
                }
            }
        })
    }
}