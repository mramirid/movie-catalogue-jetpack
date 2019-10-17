package com.mramirid.moviecatalogue.utils;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;
import com.mramirid.moviecatalogue.data.source.remote.response.ItemResponse;

import java.util.ArrayList;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_MOVIE;
import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_TV_SHOW;

public class FakeDataDummy {

	public static ArrayList<ItemEntity> getDummyMovies() {
		ArrayList<ItemEntity> movies = new ArrayList<>();

		movies.add(new ItemEntity(
				1001,
				"/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
				"A Star is Born",
				TYPE_MOVIE,
				"Drama, Romance, Music",
				"Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
				"English",
				"2018",
				7.5f / 2
		));
		movies.add(new ItemEntity(
				1002,
				"/xRWht48C2V8XNfzvPehyClOvDni.jpg",
				"Alita: Battle Angel",
				TYPE_MOVIE,
				"Action, Science Fiction, Thriller, Adventure",
				"When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
				"English",
				"2019",
				6.8f / 2
		));
		movies.add(new ItemEntity(
				1003,
				"/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
				"Aquaman",
				TYPE_MOVIE,
				"Action, Adventure, Fantasy",
				"Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
				"English",
				"2018",
				6.8f / 2
		));
		movies.add(new ItemEntity(
				1004,
				"/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
				"Bohemian Rhapsody",
				TYPE_MOVIE,
				"Drama, Music",
				"Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
				"English",
				"2018",
				8.0f / 2
		));
		movies.add(new ItemEntity(
				1005,
				"/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
				"Cold Pursuit",
				TYPE_MOVIE,
				"Action",
				"The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
				"English",
				"2019",
				5.4f / 2
		));
		movies.add(new ItemEntity(
				1006,
				"/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
				"Creed II",
				TYPE_MOVIE,
				"Drama",
				"Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
				"English",
				"2018",
				6.7f / 2
		));
		movies.add(new ItemEntity(
				1007,
				"/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
				"Fantastic Beasts: The Crimes of Grindelwald",
				TYPE_MOVIE,
				"Adventure, Fantasy, Family",
				"Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
				"English",
				"2018",
				6.9f / 2
		));
		movies.add(new ItemEntity(
				1008,
				"/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
				"Glass",
				TYPE_MOVIE,
				"Thriller, Drama, Science Fiction",
				"In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
				"English",
				"2019",
				6.5f / 2
		));
		movies.add(new ItemEntity(
				1009,
				"/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
				"How to Train Your Dragon: The Hidden World",
				TYPE_MOVIE,
				"Animation, Family, Adventure",
				"As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
				"English",
				"2019",
				7.7f / 2
		));
		movies.add(new ItemEntity(
				1010,
				"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
				"Avengers: Infinity War",
				TYPE_MOVIE,
				"Adventure, Action, Science Fiction",
				"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
				"English",
				"2018",
				8.3f / 2
		));

		return movies;
	}

	public static ArrayList<ItemEntity> getDummyTvShows() {
		ArrayList<ItemEntity> tvShows = new ArrayList<>();

		tvShows.add(new ItemEntity(
				2001,
				"/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
				"Arrow",
				TYPE_TV_SHOW,
				"Crime, Drama, Mystery, Action, Adventure",
				"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
				"English",
				"2012",
				5.8f / 2
		));
		tvShows.add(new ItemEntity(
				2002,
				"/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
				"Doom Patrol",
				TYPE_TV_SHOW,
				"Sci-Fi, Fantasy, Action, Adventure",
				"The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
				"English",
				"2019",
				0.0f / 2
		));
		tvShows.add(new ItemEntity(
				2003,
				"/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
				"Dragon Ball",
				TYPE_TV_SHOW,
				"Comedy, Sci-Fi, Fantasy, Animation, Action, Adventure",
				"Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
				"Japanese",
				"1986",
				7.0f / 2
		));
		tvShows.add(new ItemEntity(
				2004,
				"/58GKcwFV3lpVOGzybeMrrNOjHpz.jpg",
				"Fairy Tail",
				TYPE_TV_SHOW,
				"Action, Adventure, Animation, Comedy, Sci-Fi, Fantasy",
				"Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
				"Japanese",
				"2009",
				6.5f / 2
		));
		tvShows.add(new ItemEntity(
				2005,
				"/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
				"Family Guy",
				TYPE_TV_SHOW,
				"Animation, Comedy",
				"Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
				"English",
				"1999",
				6.5f / 2
		));
		tvShows.add(new ItemEntity(
				2006,
				"/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
				"The Flash",
				TYPE_TV_SHOW,
				"Drama, Sci-Fi, Fantasy",
				"After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become…The Flash.",
				"English",
				"2014",
				6.7f / 2
		));
		tvShows.add(new ItemEntity(
				2007,
				"/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
				"Game of Thrones",
				TYPE_TV_SHOW,
				"Sci-Fi, Drama, Action, Adventure",
				"Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
				"English",
				"2011",
				8.1f / 2
		));
		tvShows.add(new ItemEntity(
				2008,
				"/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
				"Gotham",
				TYPE_TV_SHOW,
				"Drama, Fantasy, Crime",
				"Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
				"English",
				"2014",
				6.8f / 2
		));
		tvShows.add(new ItemEntity(
				2009,
				"/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
				"Grey's Anatomy",
				TYPE_TV_SHOW,
				"Drama",
				"Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
				"English",
				"2005",
				6.3f / 2
		));
		tvShows.add(new ItemEntity(
				2010,
				"/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
				"Hanna",
				TYPE_TV_SHOW,
				"Action, Adventure, Drama",
				"This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
				"English",
				"2019",
				6.6f / 2
		));

		return tvShows;
	}

	public static ArrayList<ItemResponse> getRemoteDummyMovies() {
		ArrayList<ItemResponse> movies = new ArrayList<>();

		movies.add(new ItemResponse(
				1001,
				"/wrFpXMNBRj2PBiN4Z5kix51XaIZ.jpg",
				"A Star is Born",
				TYPE_MOVIE,
				"Drama, Romance, Music",
				"Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
				"English",
				"2018",
				7.5f / 2
		));
		movies.add(new ItemResponse(
				1002,
				"/xRWht48C2V8XNfzvPehyClOvDni.jpg",
				"Alita: Battle Angel",
				TYPE_MOVIE,
				"Action, Science Fiction, Thriller, Adventure",
				"When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
				"English",
				"2019",
				6.8f / 2
		));
		movies.add(new ItemResponse(
				1003,
				"/5Kg76ldv7VxeX9YlcQXiowHgdX6.jpg",
				"Aquaman",
				TYPE_MOVIE,
				"Action, Adventure, Fantasy",
				"Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
				"English",
				"2018",
				6.8f / 2
		));
		movies.add(new ItemResponse(
				1004,
				"/lHu1wtNaczFPGFDTrjCSzeLPTKN.jpg",
				"Bohemian Rhapsody",
				TYPE_MOVIE,
				"Drama, Music",
				"Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
				"English",
				"2018",
				8.0f / 2
		));
		movies.add(new ItemResponse(
				1005,
				"/hXgmWPd1SuujRZ4QnKLzrj79PAw.jpg",
				"Cold Pursuit",
				TYPE_MOVIE,
				"Action",
				"The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
				"English",
				"2019",
				5.4f / 2
		));
		movies.add(new ItemResponse(
				1006,
				"/v3QyboWRoA4O9RbcsqH8tJMe8EB.jpg",
				"Creed II",
				TYPE_MOVIE,
				"Drama",
				"Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
				"English",
				"2018",
				6.7f / 2
		));
		movies.add(new ItemResponse(
				1007,
				"/fMMrl8fD9gRCFJvsx0SuFwkEOop.jpg",
				"Fantastic Beasts: The Crimes of Grindelwald",
				TYPE_MOVIE,
				"Adventure, Fantasy, Family",
				"Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
				"English",
				"2018",
				6.9f / 2
		));
		movies.add(new ItemResponse(
				1008,
				"/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg",
				"Glass",
				TYPE_MOVIE,
				"Thriller, Drama, Science Fiction",
				"In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
				"English",
				"2019",
				6.5f / 2
		));
		movies.add(new ItemResponse(
				1009,
				"/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg",
				"How to Train Your Dragon: The Hidden World",
				TYPE_MOVIE,
				"Animation, Family, Adventure",
				"As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
				"English",
				"2019",
				7.7f / 2
		));
		movies.add(new ItemResponse(
				1010,
				"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg",
				"Avengers: Infinity War",
				TYPE_MOVIE,
				"Adventure, Action, Science Fiction",
				"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
				"English",
				"2018",
				8.3f / 2
		));

		return movies;
	}

	public static ArrayList<ItemResponse> getRemoteDummyTvShows() {
		ArrayList<ItemResponse> tvShows = new ArrayList<>();

		tvShows.add(new ItemResponse(
				2001,
				"/mo0FP1GxOFZT4UDde7RFDz5APXF.jpg",
				"Arrow",
				TYPE_TV_SHOW,
				"Crime, Drama, Mystery, Action, Adventure",
				"Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
				"English",
				"2012",
				5.8f / 2
		));
		tvShows.add(new ItemResponse(
				2002,
				"/nVN7Dt0Xr78gnJepRsRLaLYklbY.jpg",
				"Doom Patrol",
				TYPE_TV_SHOW,
				"Sci-Fi, Fantasy, Action, Adventure",
				"The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
				"English",
				"2019",
				0.0f / 2
		));
		tvShows.add(new ItemResponse(
				2003,
				"/3wx3EAMtqnbSLhGG8NrqXriCUIQ.jpg",
				"Dragon Ball",
				TYPE_TV_SHOW,
				"Comedy, Sci-Fi, Fantasy, Animation, Action, Adventure",
				"Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the dragon balls brought her to Goku's home. Together, they set off to find all seven dragon balls in an adventure.",
				"Japanese",
				"1986",
				7.0f / 2
		));
		tvShows.add(new ItemResponse(
				2004,
				"/58GKcwFV3lpVOGzybeMrrNOjHpz.jpg",
				"Fairy Tail",
				TYPE_TV_SHOW,
				"Action, Adventure, Animation, Comedy, Sci-Fi, Fantasy",
				"Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
				"Japanese",
				"2009",
				6.5f / 2
		));
		tvShows.add(new ItemResponse(
				2005,
				"/gBGUL1UTUNmdRQT8gA1LUV4yg39.jpg",
				"Family Guy",
				TYPE_TV_SHOW,
				"Animation, Comedy",
				"Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
				"English",
				"1999",
				6.5f / 2
		));
		tvShows.add(new ItemResponse(
				2006,
				"/wHa6KOJAoNTFLFtp7wguUJKSnju.jpg",
				"The Flash",
				TYPE_TV_SHOW,
				"Drama, Sci-Fi, Fantasy",
				"After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become…The Flash.",
				"English",
				"2014",
				6.7f / 2
		));
		tvShows.add(new ItemResponse(
				2007,
				"/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
				"Game of Thrones",
				TYPE_TV_SHOW,
				"Sci-Fi, Drama, Action, Adventure",
				"Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
				"English",
				"2011",
				8.1f / 2
		));
		tvShows.add(new ItemResponse(
				2008,
				"/4XddcRDtnNjYmLRMYpbrhFxsbuq.jpg",
				"Gotham",
				TYPE_TV_SHOW,
				"Drama, Fantasy, Crime",
				"Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
				"English",
				"2014",
				6.8f / 2
		));
		tvShows.add(new ItemResponse(
				2009,
				"/jnsvc7gCKocXnrTXF6p03cICTWb.jpg",
				"Grey's Anatomy",
				TYPE_TV_SHOW,
				"Drama",
				"Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
				"English",
				"2005",
				6.3f / 2
		));
		tvShows.add(new ItemResponse(
				2010,
				"/5nSSkcM3TgpllZ7yTyBOQEgAX36.jpg",
				"Hanna",
				TYPE_TV_SHOW,
				"Action, Adventure, Drama",
				"This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
				"English",
				"2019",
				6.6f / 2
		));

		return tvShows;
	}
}
