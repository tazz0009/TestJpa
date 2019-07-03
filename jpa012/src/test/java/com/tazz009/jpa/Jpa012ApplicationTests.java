package com.tazz009.jpa;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tazz009.jpa.entities.Album;
import com.tazz009.jpa.entities.Book;
import com.tazz009.jpa.entities.Item;
import com.tazz009.jpa.entities.Movie;
import com.tazz009.jpa.services.ItemService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Jpa012ApplicationTests {

	@Autowired
	private ItemService itemService;
	
	@Before
	public void before() {
	}
	
	@After
	public void after() {
	}

	@Test
	public void testA_SAVE_Album() throws Exception {
		Item album1 = Album.builder()
				.name("앨범1")
				.price(100)
				.artist("artist1")
				.build();
		Item savedAlbum1 = itemService.save(album1);
		
		assertThat(savedAlbum1.getName(), is(album1.getName()));
		assertThat(savedAlbum1.getPrice(), is(album1.getPrice()));
		assertThat(((Album) savedAlbum1).getArtist(), is(((Album) album1).getArtist()));
	}

	@Test
	public void testB_SAVE_Movie() throws Exception {
		Item movie1 = Movie.builder()
				.name("영화1")
				.price(1000)
				.director("감독1")
				.actor("배우1")
				.build();
		Item savedMovie1 = itemService.save(movie1);
		
		assertThat(savedMovie1.getName(), is(movie1.getName()));
		assertThat(savedMovie1.getPrice(), is(movie1.getPrice()));
		assertThat(((Movie) savedMovie1).getDirector(), is(((Movie) movie1).getDirector()));
		assertThat(((Movie) savedMovie1).getActor(), is(((Movie) movie1).getActor()));
	}

	@Test
	public void testC_SAVE_Book() throws Exception {
		Item book1 = Book.builder()
				.name("책1")
				.price(1000)
				.author("작가1")
				.isbn("ISBN1")
				.build();
		Item savedBook1 = itemService.save(book1);
		
		assertThat(savedBook1.getName(), is(book1.getName()));
		assertThat(savedBook1.getPrice(), is(book1.getPrice()));
		assertThat(((Book) savedBook1).getAuthor(), is(((Book) book1).getAuthor()));
		assertThat(((Book) savedBook1).getIsbn(), is(((Book) book1).getIsbn()));
	}
	
}
