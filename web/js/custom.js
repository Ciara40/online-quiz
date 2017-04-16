/**
 * Created by usha on 4/16/2017.
 */
function checkAnswer() {
    // var correctAns = document.getElementById("correctAns").value;
    var selected = document.querySelector("input[name='choice']:checked");
    console.log("in method", selected);
    if(null == selected || undefined == selected) {
        document.getElementById("selectMsg").innerHTML = "Please select one option.";
        return false;
    }
    /*else {
        document.getElementById("correctness").innerHTML = "Wrong!!!";
        document.getElementById("correctAnswer").innerHTML = "The correct answer is: " +correctAns;
    }*/
    return true;
}