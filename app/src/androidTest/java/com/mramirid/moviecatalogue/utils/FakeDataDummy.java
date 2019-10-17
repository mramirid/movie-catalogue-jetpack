package com.mramirid.moviecatalogue.utils;

import com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity;

import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_MOVIE;
import static com.mramirid.moviecatalogue.data.source.local.entity.ItemEntity.TYPE_TV_SHOW;

public class FakeDataDummy {

	public static ItemEntity getDummyMovie() {
		return new ItemEntity(
				475557,
				"/hO7KbdvGOtDdeg0W4Y5nKEHeDDh.jpg",
				"Joker",
				TYPE_MOVIE,
				"Crime, Drama, Thriller",
				"During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
				"EN",
				"2019",
				8.8f / 2
		);
	}

	public static ItemEntity getDummyTvShow() {
		return new ItemEntity(
				456,
				"/yTZQkSsxUFJZJe67IenRM0AEklc.jpg",
				"The Simpsons",
				TYPE_TV_SHOW,
				"Animation, Comedy",
				"Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
				"EN",
				"1989",
				7.1f / 2
		);
	}
}
