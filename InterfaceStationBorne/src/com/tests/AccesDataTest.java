package com.tests;
import com.persistance.*;

import static org.junit.Assert.*;

import com.metier.*;

import java.util.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AccesDataTest {
	
	@Before
	public void setUp() throws Exception {
	}
	//private AccesData a;
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetListeTypeCharge() {
		assertEquals(6,AccesData.getListeTypeCharge().size());
	}

	@Test
	public void testGetListeStation() {
		assertEquals(3,AccesData.getListeStation().size());
	}

	@Test
	public void testGetListBorne() {
		assertEquals(6,AccesData.getListBorne().size());
	}

	@Test
	public void testGetBorneStation() {
		assertEquals(3,AccesData.getBorneStation(1).size());
	}

	@Test
	public void testGetTypeCharge() {
		assertEquals(1,AccesData.getTypeCharge(1).getCodeTypeCharge());
	}
	
	@Test
	
	public void testAddDeleteTypeCharge() {
		AccesData a = new AccesData();
		TypeCharge t=new TypeCharge("tres rapide", 100);
		assertTrue(a.addTypeCharge(t));
		// test suppression typecharge utilisée	
		t=AccesData.getTypeCharge(2);
		assertFalse(a.deleteTypeCharge(t));
		// suppresssion du dernier type charge inséré pour remettre la base en état initial
		ArrayList<TypeCharge> listeTypeCharge=AccesData.getListeTypeCharge();
		// ajout en dernier, donc on efface le dernier ajouté en size() -1
		assertTrue(a.deleteTypeCharge(listeTypeCharge.get(listeTypeCharge.size()-1)));
	}
	
	@Test
	
	public void testDeleteTypeCharge(){
		TypeCharge t=new TypeCharge("tres rapide", 100);
		AccesData a=new AccesData();
		a.addTypeCharge(t);
		assertTrue(a.deleteTypeCharge(t));
	}
	
	
	
}
