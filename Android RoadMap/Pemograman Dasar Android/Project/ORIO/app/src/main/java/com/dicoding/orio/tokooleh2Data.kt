package com.dicoding.orio

object tokooleh2Data {
    private val namatoko =  arrayOf(
            "Mega Rasa Oleh-oleh Khas Pekanbaru",
            "Oleh-oleh Pekanbaru Batik Riau Malai",
            "Queen puff Toko Oleh-oleh Pekanbaru",
            "Insyira oleh-oleh pekanbaru",
            "Bunga Rinjani Gerai oleh oleh Pekanbaru-Riau",
            "Pusat oleh oleh Nadhira Napoleon Pekanbaru",
            "Hanisuncake, oleh-oleh PEKANBARU RIAU",
            "Dapoer Ummi Bolu Kemojo Oleh oleh Khas Pekanbaru",
            "Toko oleh-oleh Dara Pekanbaru",
            "Toko Oleh Oleh Jingga Khas Riau"
    )

    private val tokoImages = intArrayOf(
            R.drawable.img_1_megarasa,
            R.drawable.img_2_batikmalai,
            R.drawable.img_3_queenpuff,
            R.drawable.img_4_insyra,
            R.drawable.img_5_bungarinja,
            R.drawable.img_6_nadhira,
            R.drawable.img_7_hanisuncake,
            R.drawable.img_8_dapoerummi,
            R.drawable.img_9_dara,
            R.drawable.img_10_jingga)

    private val daerahtoko = arrayOf(
            "Pekanbaru",
            "Pekanbaru",
            "Pekanbaru",
            "Pekanbaru",
            "Pekanbaru",
            "Pekanbaru",
            "Pekanbaru",
            "Pekanbaru",
            "Pekanbaru",
            "Pekanbaru"
    )

    private val alamat_toko = arrayOf(
            "Jl. Jendral Sudirman No. 397 C-D, Cinta Raja, Kec. Sail, Kota Pekanbaru, Riau 28125",
            "Pemancar TVRI Riau, Jl. Durian no : 21a Simpang Empat, Kelurahan, Labuh Baru Tim., Kec. Payung Sekaki, Kota Pekanbaru, Riau 28292",
            "Jl. Serayu Kelurahan No.18, Labuh Baru Tim., Kec. Payung Sekaki, Kota Pekanbaru, Riau 28156",
            "Jalan arifin Ahmad, kecamatan marpoyan damai, kelurahan sidolmulyo timur, Sidomulyo Tim., Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28125",
            "Jl. Jend. Ahmad Yani Kelurahan No.158, Pulau Karam, Kec. Sukajadi, Kota Pekanbaru, Riau 28156",
            "Jl. Jend. Sudirman No.177, Tengkerang Sel., Kec. Bukit Raya, Kota Pekanbaru, Riau 28288",
            "Jl. Utama ruko no. 1, Rejosari, Kec. Tenayan Raya, Kota Pekanbaru, Riau 28281",
            "Jl Bakti VIII No 3 Rt 03 Rw 011 Kelurahan Tangkerang barat Kec. Marpoyan, Tengkerang Bar., Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28282",
            "Jl. Hangtuah Ujung No.312C, Rejosari, Kec. Tenayan Raya, Kota Pekanbaru, Riau 28111",
            "Jl. Kaharuddin Nst No.26, Maharatu, Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28125"
    )

    private val koordinat_toko = arrayOf(
            "0.5040048983713965, 101.45356229881395",
            "0.5040048983713965, 101.45356229881395",
            "0.5040048983713965, 101.45356229881395",
            "0.5040048983713965, 101.45356229881395",
            "0.5276186668178698, 101.44392995549086",
            "0.4963706957755897, 101.45562342620693",
            "0.4963706957755897, 101.45562342620693",
            "0.4963706957755897, 101.45562342620693",
            "0.4963706957755897, 101.45562342620693",
            "0.4963706957755897, 101.45562342620693"
    )


    val listData: ArrayList<tokooleh2>
        get() {
            val list = arrayListOf<tokooleh2>()
            for (position in namatoko.indices) {
                val toko_oleh_oleh = tokooleh2()
                toko_oleh_oleh.nama_toko = namatoko[position]
                toko_oleh_oleh.daerah_toko = daerahtoko[position]
                toko_oleh_oleh.photo_toko = tokoImages[position]
                toko_oleh_oleh.alamat_toko = alamat_toko[position]
                toko_oleh_oleh.koordinat_toko = koordinat_toko[position]
                list.add(toko_oleh_oleh)
            }
            return list
        }
}