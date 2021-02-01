package testing;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;



import resource.DBResource;

public class DBResourceTest {

	@Test
	public void test() {
		Connection res=DBResource.getDbConnection();
		assertEquals(null,res);
	}

}
