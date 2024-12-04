package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"sort"
	"strings"
)

func main() {
	file, err := os.Open("challenge")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	var leftList, rightList = readFileToSlices(file)

	var result = calculateResult(leftList, rightList)

	var secondResult = calculateResultTwo(leftList, rightList)

	fmt.Println("Result: ", result)
	fmt.Println("Result: ", secondResult)
}

func calculateResultTwo(leftList []int, rightList []int) int {
	var result = 0
	for i := 0; i < len(leftList); i++ {
		var multiplier = 0
		for j := 0; j < len(rightList); j++ {
			if leftList[i] == rightList[j] {
				multiplier += 1
			}
		}
		result += leftList[i] * multiplier
	}

	return result
}

func calculateResult(leftList []int, rightList []int) int {
	sort.Ints(leftList)
	sort.Ints(rightList)

	var result = 0

	for i := 0; i < len(leftList); i++ {
		var value = leftList[i] - rightList[i]
		if value < 0 {
			value = value * -1
		}
		result += value
	}
	return result
}

func readFileToSlices(file *os.File) ([]int, []int) {
	scanner := bufio.NewScanner(file)

	var leftList []int
	var rightList []int

	for scanner.Scan() {

		line := scanner.Text()

		parts := strings.Fields(line)

		var first, second int
		_, err := fmt.Sscanf(parts[0], "%d", &first)
		if err != nil {
			log.Fatal("Error parsing first number: ", err)
		}
		_, err = fmt.Sscanf(parts[1], "%d", &second)
		if err != nil {
			log.Fatal("Error parsing second number: ", err)
		}

		leftList = append(leftList, first)
		rightList = append(rightList, second)

	}

	if err := scanner.Err(); err != nil {
		log.Fatal(err)
	}
	return leftList, rightList
}
