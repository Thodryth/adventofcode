package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strconv"
	"strings"
)

func main() {
	file, err := os.Open("challenge")
	if err != nil {
		log.Fatal(err)
	}
	defer file.Close()

	var newNums [][]int

	var lines = readFileToSlices(file)

	for _, line := range lines {
		var nums = lineToNum(line)
		if constantDirection(nums) {
			newNums = append(newNums, nums)
		}
	}

	var muchNewerNums [][]int

	for _, nums := range newNums {
		var breaking = false
		for i := 0; i < len(nums)-1; i++ {
			diff := changeNegative(nums[i] - nums[i+1])
			if diff != 1 && diff != 2 && diff != 3 {
				breaking = true
			}
		}

		if !breaking {
			muchNewerNums = append(muchNewerNums, nums)
		}

	}

	fmt.Print(len(muchNewerNums))
}

func readFileToSlices(file *os.File) []string {
	scanner := bufio.NewScanner(file)

	var lines []string

	for scanner.Scan() {

		line := scanner.Text()
		lines = append(lines, line)

	}

	return lines
}

func lineToNum(line string) []int {
	strs := strings.Split(line, " ")

	var nums []int

	for _, str := range strs {
		num, err := strconv.Atoi(str)
		if err != nil {
			fmt.Println("Error converting string to int:", err)
		}
		nums = append(nums, num)
	}

	return nums
}

func constantDirection(nums []int) bool {
	if nums[0] > nums[1] {
		for i := 0; i < len(nums)-1; i++ {
			if nums[i+1] > nums[i] {
				return false
			}
		}
	} else if nums[0] < nums[1] {
		for i := 0; i < len(nums)-1; i++ {
			if nums[i+1] < nums[i] {
				return false
			}
		}
	}
	return true
}

func changeNegative(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
