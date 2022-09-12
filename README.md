This is a REST API with unit tests that provides the following functionality of a wallet:

Given a wallet of notes and a payment amount, return the minimum number of notes that exactly match the payment amount.
If there is no combination of notes that equal the payment amount exactly, return an empty list.

inputs:
	wallet	- provided as a list of integers. values can be 1, 5, 10, 20, 50
		- notes do not have to be in order and there can be duplicates e.g. (1, 50, 5, 10, 1, 20, 20, 5, 1, 50)
	amount	- integer

examples:
	input: notes = [1, 50, 5, 10, 1, 20, 20, 5, 1, 50], amount = 123
	output: [50, 50, 20, 1, 1, 1]

	input: notes = [10, 5, 5, 1], amount = 12
	output: []
