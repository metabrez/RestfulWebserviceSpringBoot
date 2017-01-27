# RestfulWebserviceSpringBoot

<h2>For Testing using postman<h2>
<pre>When the application is started it creates 10 employees with Id starting from 1 to 10. Id is AutoIncrement </pre>


<h4>http://localhost:8090/secure/allEmployee getAllEmployee<h4>
<h4>http://localhost:8090/secure/employee/{id} GET<h4>
<h4>http://localhost:8090/secure/employee/{id}  Delete<h4>
<h4>http://localhost:8090/secure/employee     POST <h4>
    <h5> RequestBody {"name":"Employee12","salary":20.5}<h5>
<h4>http://localhost:8090/secure/employee/{id}  PUT<h4>
      <h5>RequestBody {"name":"Employee11 changed to","salary":20.5}<h5>
