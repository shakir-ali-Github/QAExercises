"use strict";

const numberInput = document.querySelector("#numberInput");
let firstNumber;
let operator;
let finalNumber;


const clearAC = () => {
    const resetAC = 0;
    numberInput.value = resetAC
}

const zero = () => {
    numberInput.value +=0
}

const one = () => {
    numberInput.value +=1
}

const two = () => {
    numberInput.value +=2
}

const three = () => {
    numberInput.value +=3
}

const four = () => {
    numberInput.value +=4
}

const five = () => {
    numberInput.value +=5
}

const six = () => {
    numberInput.value +=6
}

const seven = () => {
    numberInput.value +=7
}

const eight = () => {
    numberInput.value +=8
}

const nine = () => {
    numberInput.value +=9
}

const addNum = () => {
    firstNumber = parseFloat(numberInput.value)
    operator = "+"
}

const subNum = () => {
    firstNumber = parseFloat(numberInput.value)
    operator = "-"
}

const multNum = () => {
    firstNumber = parseFloat(numberInput.value)
    operator = "*"
}

const divNum = () => {
    firstNumber = parseFloat(numberInput.value)
    operator = "/"
}

const equalNum = () => {
    if (operator == "+") {
        finalNumber = firstNumber + parseFloat(numberInput.value)
        numberInput.value = finalNumber
    } else if (operator == "-") {
        finalNumber = firstNumber - parseFloat(numberInput.value)
        numberInput.value = finalNumber
    } else if (operator == "*") {
        finalNumber = firstNumber * parseFloat(numberInput.value)
        numberInput.value = finalNumber
    } else if (operator == "/") {
        finalNumber = firstNumber / parseFloat(numberInput.value)
        numberInput.value = finalNumber
    }

    
}