<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Landing Page With Light/Dark Mode</title>
    <link rel="stylesheet" href="<c:url value="/styles/menuStyle.css"/>" />
    <!-- Swiper CSS -->
    <link rel="stylesheet" href="<c:url value="/styles/swiper-bundle.min.css"/>"/>

    <!-- CSS -->
    <link rel="stylesheet" href="<c:url value="/styles/card-list-style.css"/>">

    <style>
      /* Modalning asosiy konteyneri */
      .modal {
        display: none;
        position: fixed;
        z-index: 1;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto;
        background-color: rgba(0, 0, 0, 0.7);
      }

      /* Modal oynasi */
      .modal-content {
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        display: flex;
        flex-direction: column;
        align-items: center;
        padding: 20px;
        width: 300px;
        height: 300px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        border-radius: 8px;
        background-color: #919191;
      }

    </style>
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
                <li><a href="/payment"><h3>PAYMENT</h3></a></li>
                <li><a href="/history"><h3>HISTORY</h3></a></li>
                <li><a href="/p2p"><h3>P2P</h3></a></li>
<!--                <li><a href="#" class="btn">Sign up</a></li>-->
              </ul>
            </div>

            <div class="overlay"></div>

            <div class="hamburger-menu">
              <div class="bar"></div>
            </div>
          </div>
        </header>

        <div style="text-align: center">
          <div style="border: 5px solid #ff7d00;
                      border-radius: 10px;
                      width: 50%;
                      padding: 30px 10px;
                      margin-left: 25%;
                      text-align: center;">
            <h3 style="color: #ff7d00">Balance</h3>
            <h2>${balance} so'm</h2>
          </div>
        </div>

          <%--    cards list     --%>
        <div class="slide-container swiper" >
          <link>
          <div class="slide-content">
            <div class="card-wrapper swiper-wrapper">
              <c:forEach items="${cards}" var="card">
                <div class="card swiper-slide">
                  <div class="image-content">
                    <span class="overlay"></span>

                    <div class="card-image">
                      <img src="<c:url value="/styles/img/${card.type}.jpg"/>" alt="" class="card-img">
                    </div>
                  </div>

                  <div class="card-content">
                    <h2 class="name">${card.type}</h2>
                    <p class="description">Balance : ${card.balance} so'm</p>
                  </div>
                </div>
              </c:forEach>
              <div class="card swiper-slide">
                <div class="image-content">
                  <span class="overlay"></span>

                  <div class="card-image">
                    <img src="<c:url value="/styles/img/newCard.jpg"/>" alt="" class="card-img">
                  </div>
                </div>

                <div class="card-content">
                  <a class="button" onclick="openModal()">Add Card</a>
                </div>
              </div>
            </div>
          </div>

          <div class="swiper-button-next swiper-navBtn"></div>
          <div class="swiper-button-prev swiper-navBtn"></div>
          <div class="swiper-pagination"></div>
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


    <!-- Modal -->
    <div id="profileModal" class="modal">
      <div class="modal-content">
        <span onclick="closeModal()" style="float: right; cursor: pointer;">&times;</span>

        <form action="/manage-cards/add-card" method="post">
          <input type="hidden" name="user" value="${user}">
          <input type="hidden" name="owner" value="${user.id}">
          <input type="text" name="cardNumber" placeholder="Enter card number">
          <input type="password" name="password" placeholder="Enter card password">
          <input type="number" name="balance" placeholder="Enter balance">
          <input type="text" name="type" placeholder="Choose a card type" list="categories">
          <datalist id="categories">
            <option value="UZCARD">
            <option value="HUMO">
            <option value="VISA">
          </datalist>
          <input type="hidden" name="status" value="true">
          <button>submit</button>
        </form>

        <!-- Boshqa ma'lumotlar uchun kerakli elementlarni qo'shing -->
      </div>
    </div>

    <script>
      function openModal() {
        var modal = document.getElementById('profileModal');
        modal.style.display = 'block';
      }

      function closeModal() {
        var modal = document.getElementById('profileModal');
        modal.style.display = 'none';
      }
    </script>




    <!-- Swiper JS -->
    <script src="../../styles/swiper-bundle.min.js"></script>

    <!-- JavaScript -->
    <script src="../../styles/script.js"></script>

    <script src="https://kit.fontawesome.com/a81368914c.js"></script>
    <script src="../../styles/app2.js"></script>
  </body>
</html>
