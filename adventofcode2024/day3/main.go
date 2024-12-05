package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"regexp"
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
		fmt.Println(line)
		regexPattern := `mul\((\d+),(\d+)\)` // Sucht nach einer oder mehreren Ziffern

		// Kompiliere den regulären Ausdruck
		re := regexp.MustCompile(regexPattern)

		// Finde alle Übereinstimmungen
		matches := re.FindAllString(line, -1)

		// Ergebnisse ausgeben
		fmt.Println("Gefundene Matches:", matches)

	}
	// Regulärer Ausdruck für Zahlen

}
