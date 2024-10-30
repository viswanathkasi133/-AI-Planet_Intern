/**
 * 
 */
function askQuestion() {
    const questionInput = document.getElementById('questionInput');
    const question = questionInput.value;
    stompClient.send("/app/ask", {}, JSON.stringify({ question: question }));
}
