package ch.frankel.blog.tomee;

import static org.jboss.shrinkwrap.api.ShrinkWrap.create;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import model.Item;

import org.apache.commons.io.FileUtils;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import controller.ItemFacade;

@RunWith(Arquillian.class)
public class TomEeIT {

	private static final String ROOT = "src/main/webapp";

	@PersistenceContext(unitName = "catalogPU")
	private EntityManager em;

	@Inject
	private UserTransaction ut;

	@Inject
	private ItemFacade itemFacade;

	@Deployment
	public static WebArchive createDeployment() {

		WebArchive war = create(WebArchive.class).addPackage("controller").addPackage("model").addPackage("web")
				.addClass(TomEeIT.class).addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
				.addAsWebInfResource("beans.xml", "beans.xml").addAsWebResource(new File(ROOT, "detail.xhtml"))
				.addAsWebResource(new File(ROOT, "index.html")).addAsWebResource(new File(ROOT, "list.xhtml"))
				.addAsWebResource(new File(ROOT, "resources/css/styles.css"), "resources/css/styles.css")
				.addAsWebResource(new File(ROOT, "resources/images/anthony-s.jpg"), "resources/images/anthony-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/anthony.jpg"), "resources/images/anthony.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/bailey-s.jpg"), "resources/images/bailey-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/bailey.jpg"), "resources/images/bailey.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/banner_logo.gif"), "resources/images/banner_logo.gif")
				.addAsWebResource(new File(ROOT, "resources/images/bob-s.jpg"), "resources/images/bob-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/bob.jpg"), "resources/images/bob.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/cat1.gif"), "resources/images/cat1.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat10.gif"), "resources/images/cat10.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat11.gif"), "resources/images/cat11.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat12.gif"), "resources/images/cat12.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat2.gif"), "resources/images/cat2.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat3.gif"), "resources/images/cat3.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat4.gif"), "resources/images/cat4.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat5.gif"), "resources/images/cat5.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat6.gif"), "resources/images/cat6.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat7.gif"), "resources/images/cat7.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat8.gif"), "resources/images/cat8.gif")
				.addAsWebResource(new File(ROOT, "resources/images/cat9.gif"), "resources/images/cat9.gif")
				.addAsWebResource(new File(ROOT, "resources/images/chantelle-s.jpg"), "resources/images/chantelle-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/chantelle.jpg"), "resources/images/chantelle.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/charlie-s.jpg"), "resources/images/charlie-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/charlie.jpg"), "resources/images/charlie.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/elkie-s.jpg"), "resources/images/elkie-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/elkie.jpg"), "resources/images/elkie.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/faith-s.jpg"), "resources/images/faith-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/faith.jpg"), "resources/images/faith.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/gaetano-s.jpg"), "resources/images/gaetano-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/gaetano.jpg"), "resources/images/gaetano.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/harmony-s.jpg"), "resources/images/harmony-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/harmony.jpg"), "resources/images/harmony.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/katzen-s.jpg"), "resources/images/katzen-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/katzen.jpg"), "resources/images/katzen.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/mario-s.jpg"), "resources/images/mario-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/mario.jpg"), "resources/images/mario.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/mimi-s.jpg"), "resources/images/mimi-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/mimi.jpg"), "resources/images/mimi.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/monique-s.jpg"), "resources/images/monique-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/monique.jpg"), "resources/images/monique.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/olie-s.jpg"), "resources/images/olie-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/olie.jpg"), "resources/images/olie.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/paris-s.jpg"), "resources/images/paris-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/paris.jpg"), "resources/images/paris.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/princess-s.jpg"), "resources/images/princess-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/princess.jpg"), "resources/images/princess.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/simba-s.jpg"), "resources/images/simba-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/simba.jpg"), "resources/images/simba.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/thaicat-s.jpg"), "resources/images/thaicat-s.jpg")
				.addAsWebResource(new File(ROOT, "resources/images/thaicat.jpg"), "resources/images/thaicat.jpg");

		System.out.println(war.toString(true));

		return war;
	}

	@Before
	public void setup() throws Exception {

		if (em.find(Item.class, 1L) == null) {

			String script = FileUtils.readFileToString(new File("src/test/resources/scripts/catalog.sql"));

			ut.begin();

			em.joinTransaction();

			try {

				em.createNativeQuery(script).executeUpdate();

				ut.commit();

			} catch (Exception e) {

				ut.rollback();

				throw e;
			}
		}
	}

	@Test
	public void totalNumberOfItemsShouldBe29() {

		List<Item> items = itemFacade.findAll();

		assertEquals(29, items.size());
	}

	@Test
	public void firstItemShouldBeFriendlyCat() {

		Item item = itemFacade.find(1L);

		assertNotNull(item);
		assertEquals("Friendly Cat", item.getName());
	}
}
