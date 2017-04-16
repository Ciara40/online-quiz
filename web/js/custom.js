/**
 * Created by usha on 4/16/2017.
 */
function checkAnswer() {
    var correctAns = document.getElementById("correctAns").value;
    var selected = document.querySelector("input[name='choice']:checked").value;

    if(correctAns == selected) {
        document.getElementById("correctness").innerHTML = "Correct!!!";
    }else {
        document.getElementById("correctness").innerHTML = "Wrong!!!";
        document.getElementById("correctAnswer").innerHTML = "The correct answer is: " +correctAns;
    }
    return true;
}