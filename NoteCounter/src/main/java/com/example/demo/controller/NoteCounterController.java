package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.InvalidInputException;

/**
 * @author pratik.chandak
 * Rest Controller that provides the following functionality of a wallet:

 *  Given a wallet of notes and a payment amount, return the minimum number of notes that exactly match the payment amount.
	If there is no combination of notes that equal the payment amount exactly, return an empty list.
 *
 */
@RestController
public class NoteCounterController {
	
	@GetMapping(value = "/getNotes" , produces = "application/json")
	public List<Integer> getNotes(@RequestParam int amount, @RequestParam int[] notes){
		List<Integer> output = new ArrayList<Integer>();
		if(notes == null) {
			throw new InvalidInputException();
		}
		
		if(amount == 0 || notes.length == 0) {
			return output;
		}
		
		List<Integer> listOfNotes = new ArrayList<Integer>();
		for(int note : notes) {
			listOfNotes.add(note);
		}
		
		//sorting in descending order
		Collections.sort(listOfNotes,Collections.reverseOrder());
		for(int i = 0; i< listOfNotes.size(); i++) {
			if(amount >= listOfNotes.get(i)) {
				output.add(listOfNotes.get(i));
				amount = amount - listOfNotes.get(i);
			}
			
		}
		
		if(amount == 0){
			return output;
		}else {
			//return empty output if the amount doesn't match the notes combination
			return new ArrayList<Integer>();
		}
	}

}
