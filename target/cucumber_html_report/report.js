$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("JavaPractice.feature");
formatter.feature({
  "line": 3,
  "name": "Title of your feature",
  "description": "I want to use this template for my feature file\r\nI can write anything in here\r\nAny amount of text is fine",
  "id": "title-of-your-feature",
  "keyword": "Feature",
  "tags": [
    {
      "line": 2,
      "name": "@java"
    }
  ]
});
formatter.before({
  "duration": 8934173900,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "Practice makes perfect",
  "description": "",
  "id": "title-of-your-feature;practice-makes-perfect",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "I know some Java",
  "keyword": "Given "
});
formatter.step({
  "line": 11,
  "name": "I practice",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "I get better",
  "keyword": "Then "
});
formatter.match({
  "location": "JavaPractice.IKnowJava()"
});
formatter.result({
  "duration": 124292800,
  "status": "passed"
});
formatter.match({
  "location": "JavaPractice.practice()"
});
formatter.result({
  "duration": 46190062000,
  "status": "passed"
});
formatter.match({
  "location": "JavaPractice.GotTheJob()"
});
formatter.result({
  "duration": 24500,
  "status": "passed"
});
formatter.after({
  "duration": 655273600,
  "status": "passed"
});
});