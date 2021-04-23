package com.dicoding.moviecatalogue.utils

import com.dicoding.moviecatalogue.R
import com.dicoding.moviecatalogue.data.MoviesEntity
import com.dicoding.moviecatalogue.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MoviesEntity> {
        val movies = ArrayList<MoviesEntity>()

        movies.add(
            MoviesEntity(
                "Spider-Man (2002)",
                "May 1, 2002",
                "Fantasy, Action",
                "2h\n1m",
                72,
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man.",
                R.drawable.poster_spiderman
            )
        )
        movies.add(
            MoviesEntity(
                "Alita: Battle Angel (2019)",
                "January 31, 2019",
                "Action, Science Fiction, Adventure",
                "2h\n2m",
                72,
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                R.drawable.poster_alita
            )
        )
        movies.add(
            MoviesEntity(
                "Aquaman (2018)",
                "December 7, 2018",
                "Action, Adventure, Fantasy",
                "2h\n23m",
                69,
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                R.drawable.poster_aquaman
            )
        )
        movies.add(
            MoviesEntity(
                "Bohemian Rhapsody (2018)",
                "October 24, 2018",
                "Music, Drama, History",
                "2h\n15m",
                80,
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                R.drawable.poster_bohemian
            )
        )
        movies.add(
            MoviesEntity(
                "Cold Pursuit (2019)",
                "February 7, 2019",
                "Action, Crime, Thriller",
                "2h\n2m",
                57,
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                R.drawable.poster_cold_persuit
            )
        )
        movies.add(
            MoviesEntity(
                "Creed II (2018)",
                "November 21, 2018",
                "Drama",
                "2h\n10m",
                69,
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                R.drawable.poster_creed
            )
        )
        movies.add(
            MoviesEntity(
                "Fantastic Beasts: The Crimes of Grindelwald (2018)",
                "November 14, 2018",
                "Adventure, Fantasy, Drama",
                "2h\n14m",
                69,
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                R.drawable.poster_crimes
            )
        )
        movies.add(
            MoviesEntity(
                "Glass (2019)",
                "January 16, 2019",
                "Thriller, Drama, Science Fiction",
                "2h\n9m",
                67,
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                R.drawable.poster_glass
            )
        )
        movies.add(
            MoviesEntity(
                "How to Train Your Dragon (2010)",
                "March 10, 2010",
                "Fantasy, Adventure, Animation, Family",
                "1h\n38m",
                78,
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                R.drawable.poster_how_to_train
            )
        )
        movies.add(
            MoviesEntity(
                "Avengers: Infinity War (2018)",
                "April 25, 2018",
                "Adventure, Action, Science Fiction",
                "2h\n29m",
                83,
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                R.drawable.poster_infinity_war
            )
        )




        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {
        val tvshow = ArrayList<TvShowEntity>()

        tvshow.add(
            TvShowEntity(
                "Arrow (2012)",
                "October 10, 2012",
                "Crime, Drama, Mystery, Action & Adventure",
                "42m",
                66,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                R.drawable.poster_arrow
            )
        )
        tvshow.add(
            TvShowEntity(
                "Doom Patrol (2019)",
                "February 15, 2019",
                "Sci-Fi & Fantasy, Comedy, Drama",
                "49m",
                76,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                R.drawable.poster_doom_patrol
            )
        )
        tvshow.add(
            TvShowEntity(
                "Dragon Ball (1986)",
                "February 26, 1986",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "25m",
                81,
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                R.drawable.poster_dragon_ball
            )
        )
        tvshow.add(
            TvShowEntity(
                "Fairy Tail (2009)",
                "October 12, 2009",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy",
                "25m",
                78,
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                R.drawable.poster_fairytail
            )
        )
        tvshow.add(
            TvShowEntity(
                "Family Guy (1999)",
                "January 31, 1999",
                "Animation, Comedy",
                "22m",
                70,
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                R.drawable.poster_family_guy
            )
        )
        tvshow.add(
            TvShowEntity(
                "The Flash (2014)",
                "October 7, 2014",
                "Drama, Sci-Fi & Fantasy",
                "44m",
                77,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                R.drawable.poster_flash
            )
        )
        tvshow.add(
            TvShowEntity(
                "Naruto Shippūden (2007)",
                "February 15, 2007",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "25m",
                86,
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                R.drawable.poster_naruto_shipudden
            )
        )
        tvshow.add(
            TvShowEntity(
                "Gotham (2014)",
                "September 22, 2014",
                "Drama, Crime, Sci-Fi & Fantasy",
                "43m",
                75,
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                R.drawable.poster_gotham
            )
        )
        tvshow.add(
            TvShowEntity(
                "Grey's Anatomy (2005)",
                "March 27, 2005",
                "Drama",
                "43m",
                82,
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                R.drawable.poster_grey_anatomy
            )
        )
        tvshow.add(
            TvShowEntity(
                "Hanna",
                "March 28, 2019",
                "Action & Adventure, Drama",
                "50m",
                75,
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                R.drawable.poster_hanna
            )
        )
        tvshow.add(
            TvShowEntity(
                "Marvel's Iron Fist (2017)",
                "March 17, 2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "55m",
                66,
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                R.drawable.poster_iron_fist
            )
        )


        return tvshow
    }
}