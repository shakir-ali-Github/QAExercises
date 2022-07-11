"use strict";

const numberInput = document.querySelector("#numberInput");

const subBy5 = () => {
    const initialNumber = parseFloat(numberInput.value);
    const intNumSub5 = initialNumber - 5;
    numberInput.value= intNumSub5
}

const subBy1 = () => {
    const initialNumber = parseFloat(numberInput.value);
    const intNumSub1 = initialNumber - 1;
    numberInput.value= intNumSub1
}

const reset = () => {
    const initialNumber = parseFloat(numberInput.value);
    const resetNum = 0;
    numberInput.value= resetNum
}

const addBy1 = () => {
    const initialNumber = parseFloat(numberInput.value);
    const intNumAdd1 = initialNumber + 1;
    numberInput.value= intNumAdd1
}

const addBy5 = () => {
    const initialNumber = parseFloat(numberInput.value);
    const intNumAdd5 = initialNumber + 5;
    numberInput.value= intNumAdd5
}