<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Landing Page With Light/Dark Mode</title>
    <link rel="stylesheet" href="<c:url value="/styles/menuStyle.css"/>" />
  </head>
  <body>
    <main>
      <div class="big-wrapper light">
        <img src="<c:url value="/styles/img/shape.png"/>" alt="" class="shape" />

        <header>
          <div class="container">
            <div class="logo">
              <img src="<c:url value="/styles/img/logo.png"/>" alt="Logo" />
              <h1 style="color: #ff7d00">SHAFTOLI</h1>
            </div>

            <div class="links">
              <ul>
                <li><a href="manage-cards.jsp"><h3>MANAGE CARDS</h3></a></li>
                <li><a href="history.jsp"><h3>HISTORY</h3></a></li>
                <li><a href="p2p.jsp"><h3>P2P</h3></a></li>
<!--                <li><a href="#" class="btn">Sign up</a></li>-->
              </ul>
            </div>

            <div class="overlay"></div>

            <div class="hamburger-menu">
              <div class="bar"></div>
            </div>
          </div>
        </header>

        <div class="showcase-area">
          <div class="container">
<!--
            <div class="left">
              <div class="big-title">
                <h1>Future is here,</h1>
                <h1>Start Exploring now.</h1>
              </div>
              <p class="text">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit.
                Delectus eius distinctio odit, magni magnam qui ex perferendis
                vitae!
              </p>
              <div class="cta">
                <a href="#" class="btn">Get started</a>
              </div>
            </div>
-->
<!--
            <div class="right">
              <img src="./img/person.png" alt="Person Image" class="person" />
            </div>
-->
          </div>
        </div>

        <div class="bottom-area">
          <div class="container">
            <button class="toggle-btn">
              <i class="far fa-moon"></i>
              <i class="far fa-sun"></i>
            </button>
          </div>
        </div>
      </div>
    </main>

    <!-- JavaScript Files -->

    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <script src="../../styles/app2.js"></script>
  </body>
</html>
