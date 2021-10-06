var isExecuted = false;
var minutesToAdd=5;
var currentDate = new Date();
var futureDate = new Date(currentDate.getTime() + minutesToAdd*60000);
var myQuestions = [
    {
      question: "if a=5 and b=6 then 5%6 = ?",
      answers: {
        a: '3',
        b: '5',
        c: '30',
        d: '1'
      },
      correctAnswer: 'b'
    },
    {
      question: "HTML stands for ?",
      answers: {
        a: 'Hyper Text Markup Language',
        b: 'Hypothetic Text Markup Language',
        c: 'Hyper Text Madeup Language',
        d: 'Hide Text Makeup Language'
      },
      correctAnswer: 'a'
    },
    {
        question: "a = 10 and b = 5 then a+=2*b then a will be ?",
        answers: {
            a: '15',
            b: '10',
            c: '20',
            d: '25'
        },
        correctAnswer: 'c'
    },
    {
        question : "php stands for ?",
        answers: {
            a: 'Preprocessing Hyper Processor',
            b: 'Hypertext PreProcessor',
            c: 'Hypertext PostProcessor',
            d: 'None of Above'
        },
        correctAnswer: 'b'
    },
    {
        question : "<< is called as ?",
        answers: {
            a: 'insertion operator',
            b: 'extraction operator',
            c: 'modulo oprator',
            d: 'none of above'
        },
        correctAnswer: 'a'
    }
  ];
  function shuffle(array) {
    var currentIndex = array.length,  randomIndex;
  
    // While there remain elements to shuffle...
    while (0 !== currentIndex) {
  
      // Pick a remaining element...
      randomIndex = Math.floor(Math.random() * currentIndex);
      currentIndex--;
  
      // And swap it with the current element.
      [array[currentIndex], array[randomIndex]] = [
        array[randomIndex], array[currentIndex]];
    }
  
    return array;
  }
  shuffle(myQuestions);
  var quizContainer = document.getElementById('quiz');
  var resultsContainer = document.getElementById('results');
  var submitButton = document.getElementById('submit');
  generateQuiz(myQuestions, quizContainer, resultsContainer, submitButton);
  
  function generateQuiz(questions, quizContainer, resultsContainer, submitButton){
    var x = setInterval(function() {
        var now = new Date().getTime();
        var distance = futureDate - now;
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);
        document.getElementById("timer").innerHTML ="Time Remaining: " + minutes + " mins " + seconds + " sec ";
        if (distance < 0) {
        clearInterval(x);
        if(isExecuted==false){
            alert("Time's Up");
        }
        showResults(questions, quizContainer, resultsContainer);
        }
    }, 1000);
    
  
    function showQuestions(questions, quizContainer){
      // we'll need a place to store the output and the answer choices
      var output = [];
      var answers;
  
      // for each question...
      for(var i=0; i<questions.length; i++){
        
        // first reset the list of answers
        answers = [];
  
        // for each available answer...
        for(letter in questions[i].answers){
  
          // ...add an html radio button
          answers.push(
            '<label>'
              + '<input type="radio" name="question'+i+'" value="'+letter+'">'
              + letter + ': '
              + questions[i].answers[letter]
            + '</label><br>'
          );
        }
  
        // add this question and its answers to the output
        output.push(
          '<br><div class="question">Question '+ (i+1) +':<br>'+ questions[i].question + '</div>'
          + '<div class="answers">' + answers.join('') + '</div>'
        );
      }
  
      // finally combine our output list into one string of html and put it on the page
      quizContainer.innerHTML = output.join('');
    }
  
  
    function showResults(questions, quizContainer, resultsContainer){
        futureDate = new Date(currentDate.getTime());
        document.getElementById("timer").innerHTML = "EXPIRED";
        var answerContainers = quizContainer.querySelectorAll('.answers');
      
        // keep track of user's answers
        var userAnswer = [];
        var numCorrect = 0;
        
        // for each question...
        for(var i=0; i<questions.length; i++){
    
            // find selected answer
            userAnswer.push((answerContainers[i].querySelector('input[name=question'+i+']:checked')||{}).value);
            
            // if answer is correct
            if(userAnswer[i]===questions[i].correctAnswer){
            // add to the number of correct answers
            numCorrect++;
            }
        }
    
        // show number of correct answers out of total
        resultsContainer.innerHTML = 'Your Score: '+numCorrect + ' out of ' + questions.length;
        reshowQuestions(myQuestions,quizContainer);
        function reshowQuestions(questions, quizContainer){
            // we'll need a place to store the output and the answer choices
            var output = [];
            var answers;
        
            // for each question...
            for(var i=0; i<questions.length; i++){
            
            // first reset the list of answers
            answers = [];
        
            // for each available answer...
            for(letter in questions[i].answers){
        
                if(userAnswer[i]===questions[i].correctAnswer&&letter===userAnswer[i]){
                    answers.push(
                    '<label style="color:#10f508">'
                        + '<input type="radio" name="question'+i+'" value="'+letter+'"disabled checked>'
                        + letter + ': '
                        + questions[i].answers[letter]
                    + '</label><br>'
                    );
                }else if(letter===userAnswer[i]){
                    answers.push(
                    '<label style="color:red">'
                        + '<input type="radio" name="question'+i+'" value="'+letter+'"disabled checked>'
                        + letter + ': '
                        + questions[i].answers[letter]
                    + '</label><br>'
                    );
                }else if(letter===questions[i].correctAnswer){
                    answers.push(
                    '<label style="color:#10f508">'
                        + '<input type="radio" name="question'+i+'" value="'+letter+'"disabled >'
                        + letter + ': '
                        + questions[i].answers[letter]
                    + '(Correct Answer)</label><br>'
                    );
                }else{
                    answers.push(
                        '<label >'
                            + '<input type="radio" name="question'+i+'" value="'+letter+'"disabled >'
                            + letter + ': '
                            + questions[i].answers[letter]
                        + '</label><br>'
                        );
                }
            }
        
            // add this question and its answers to the output
            if(userAnswer[i]===questions[i].correctAnswer){
                output.push(
                    '<br><div class="question" style="color:#10f508">Question '+ (i+1) +':<br>'+ questions[i].question + '</div>'
                    + '<div class="answers">' + answers.join('') + '</div>'
                );
            }else{
                output.push(
                    '<br><div class="question" style="color:red">Question '+ (i+1) +':<br>'+ questions[i].question + '</div>'
                    + '<div class="answers">' + answers.join('') + '</div>'
                );
            }
            }
        
            // finally combine our output list into one string of html and put it on the page
            quizContainer.innerHTML = output.join('');
        }
      
      // gather answer containers from our quiz
      
    }
  
    // show questions right away
    showQuestions(questions, quizContainer);
    
    // on submit, show results
    submitButton.onclick = function(){
        isExecuted = confirm("Are you sure to submit this Quiz ?");
        if(isExecuted){
            showResults(questions, quizContainer, resultsContainer);
        }
    }
}
            