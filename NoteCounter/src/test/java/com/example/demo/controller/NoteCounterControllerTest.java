package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.exception.InvalidInputException;

public class NoteCounterControllerTest {
	
	 private NoteCounterController noteCounterController;
	 
	 @BeforeEach
	 private void setUp() {
		 noteCounterController = new NoteCounterController();
	 }
	 
	 @Test
	 public void testSuccessMinimumNotes() {
		 int[] notes = {1,50,5,10,1,20,20,5,1,50};
		 int amount = 123;
		 int[] expectedNotes = {50,50,20,1,1,1};
		 List<Integer> expectedOutput = createList(expectedNotes);
		 List<Integer> actualOutput = noteCounterController.getNotes(amount,notes);
		 Assertions.assertEquals(expectedOutput,actualOutput);
	 }
	 
	 @Test
	 public void testWhenNotesNotEqualToPaymentAmount() {
		 int[] notes = {10,5,5,1};
		 int amount = 12;
		 int[] expectedNotes = {};
		 List<Integer> expectedOutput = createList(expectedNotes);
		 List<Integer> actualOutput = noteCounterController.getNotes(amount,notes);
		 Assertions.assertEquals(expectedOutput,actualOutput);
	 }
	 
	 @Test
	 public void testWhenAmountIsZero() {
		 int[] notes = {10,5,5,1};
		 int amount = 0;
		 int[] expectedNotes = {};
		 List<Integer> expectedOutput = createList(expectedNotes);
		 List<Integer> actualOutput = noteCounterController.getNotes(amount,notes);
		 Assertions.assertEquals(expectedOutput,actualOutput);
	 }
	 
	 @Test
	 public void testWhenWalletIsEmpty() {
		 int[] notes = {};
		 int amount = 10;
		 int[] expectedNotes = {};
		 List<Integer> expectedOutput = createList(expectedNotes);
		 List<Integer> actualOutput = noteCounterController.getNotes(amount,notes);
		 Assertions.assertEquals(expectedOutput,actualOutput);
	 }
	 
	 @Test
	 public void testWhenAmountNegative() {
		 int[] notes = {50,100,1};
		 int amount = -50;
		 int[] expectedNotes = {};
		 List<Integer> expectedOutput = createList(expectedNotes);
		 List<Integer> actualOutput = noteCounterController.getNotes(amount,notes);
		 Assertions.assertEquals(expectedOutput,actualOutput);
	 }
	 
	 @Test
	 public void testWhenNotesInAscendingOrder() {
		 int[] notes = {50,100,200,500};
		 int amount = 500;
		 int[] expectedNotes = {500};
		 List<Integer> expectedOutput = createList(expectedNotes);
		 List<Integer> actualOutput = noteCounterController.getNotes(amount,notes);
		 Assertions.assertEquals(expectedOutput,actualOutput);
	 }
	 
	 @Test
	 public void testWhenAmountIsGreaterThanNotesInWallet() {
		 int[] notes = {50,100,200,500};
		 int amount = 5000;
		 int[] expectedNotes = {};
		 List<Integer> expectedOutput = createList(expectedNotes);
		 List<Integer> actualOutput = noteCounterController.getNotes(amount,notes);
		 Assertions.assertEquals(expectedOutput,actualOutput);
	 }
	 
	 @Test
	 public void testForNotesNull() {
		 int[] notes = null;
		 int amount = 5000;
		 int[] expectedNotes = {};
		 List<Integer> expectedOutput = createList(expectedNotes);
		 try {
			 List<Integer> actualOutput = noteCounterController.getNotes(amount,notes); 
		 }catch(InvalidInputException ex) {
			 //Catching the exception only, meaning things have worked as expected. If exception not caught, then test case failure
			 return;
		 }
		 
		Assertions.fail(); 
		 
	 }
	 
	 private List<Integer> createList(int[] notes){
		 List<Integer> expectedList = new ArrayList<Integer>();
		 for(int note : notes) {
			 expectedList.add(note);
		 }
		 return expectedList;
		 
	 }
	 
	 @AfterEach
	 public void tearDown() {
		 noteCounterController = null;
	 }

}
