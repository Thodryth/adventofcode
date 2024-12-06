package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"regexp"
	"strconv"
)

func main() {

	file, err := os.Open("test")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {

		line := scanner.Text()
		regexPattern := `mul\((\d+),(\d+)\)`

		re := regexp.MustCompile(regexPattern)

		matches := re.FindAllString(line, -1)

		// fmt.Println("Matches:", matches)

		fmt.Println("\n")
		fmt.Println()

		calc(matches[0])

		fmt.Print()

	}
}

func calc(match string) int {
	regexPattern := `(\d+)`

	re := regexp.MustCompile(regexPattern)

	nums := re.FindAllString(match, -1)
	fmt.Println(nums[0], nums[1])

	num1, err := strconv.Atoi(nums[0])
	num2, err := strconv.Atoi(nums[1])

	if err != nil {
		fmt.Println("Hoppala")
	}

	return num1 * num2
}
