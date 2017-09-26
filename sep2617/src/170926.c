/*
 ============================================================================
 Name        : p2.c
 Author      : Nadya Novak
 Date	     :09/26/17
 URL	     : https://github.com/bluebronze/EMU
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

int main(void) {
	puts("!!!Hello World!!!"); /* prints !!!Hello World!!! */

	// 1)
	int rNum;

	srand(time(NULL));

	for (int i = 0; i < 5; i++) {
		rNum = (rand() % 9 + 1);

		printf("%d ", rNum);
	}

	printf("\n\n");
	// 2)

	int arr[100];
	int temp;
	int repeat = 1;

	for (int i = 0; i < 98; i++) {
		arr[i] = 0;
	}

	arr[0] = 19;
	arr[1] = 17;
	arr[2] = 13;
	arr[3] = 11;
	arr[4] = 7;
	arr[5] = 5;
	arr[6] = 3;
	arr[7] = 2;
	arr[8] = 1;
	arr[9] = 31;
	arr[10] = 29;
	arr[11] = 30;

//REARANGER

	while (repeat == 1) {
		for (int i = 0; i < 98; i++) {
			if (arr[i] != 0) {
				if (arr[i] > arr[i + 1]) {
					temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
				}
			}
		}

		//Checker
		for (int i = 0; i < 98; i++) {
			if (arr[i + 1] != 0) {
				if (arr[i] > arr[i + 1]) {
					repeat = 1;
					i = 98; // Exit loop
				} else {
					repeat = 0;
				}

			}
		}

	}
	//PRINTER
	printf("\n\n");

	for (int i = 0; i < 98; i++) {
		if (arr[i] > 0 && arr[i] < 100) {
			printf("%d ", arr[i]);
		}

	}

	return EXIT_SUCCESS;
}

