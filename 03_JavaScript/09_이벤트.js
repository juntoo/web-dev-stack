// DOMContentLoaded 이벤트는 HTML 문서의 구조가 완전히 로드된 후 발생

window.addEventListener("DOMContentLoaded", () => {
  const h1 = document.querySelector("h1");
  h1.style.color = "blue";

  // 클릭 이벤트
  const click = document.querySelector("#click");
  click.addEventListener("click", () => {
    // 클릭 이벤트가 일어나면 행하고자 하는 코드 작성
    alert("클릭 이벤트 발생!");
    // click 색상을 변경
    click.style.color = "black";
    click.style.background = "skyblue";
  });

  const double = document.querySelector("#double");
  double.addEventListener("dblclick", () => {
    alert("더블 클릭 발생!");
  });

  const right = document.querySelector("#right");
  right.addEventListener("contextmenu", (event) => {
    alert("우클릭 발생!");
    console.log(event);
    event.preventDefault(); //우클릭 방지
  });

  const hover = document.querySelector("#hover");
  hover.addEventListener("mouseenter", () => {
    console.log("마우스 인!");
    hover.style.background = "lightblue";
    hover.textContent = "Mouse Enter!";
  });
  hover.addEventListener("mouseleave", () => {
    console.log("마우스 아웃!");
    hover.style.background = "navy";
    hover.textContent = "Mouse Leave!";
  });

  // 폼 이벤트
  // input 실시간 반영
  const input = document.querySelector("#input");
  const inputResult = document.querySelector("#inputResult");
  input.addEventListener("input", (e) => {
    inputResult.textContent = e.target.value;
  });
  // selct 선택값
  const select = document.querySelector("#select");
  const selectResult = document.querySelector("#selectResult");
  select.addEventListener("change", (e) => {
    //console.log(e.target.value);
    selectResult.textContent = e.target.value;
  });

  const form = document.querySelector("#form");
  const formInput = document.querySelector("#form input");
  form.addEventListener("submit", (e) => {
    console.log(formInput.value);
    // 값이 없는 경우 전송불가
    if (formInput.value === "") {
      e.preventDefault();
    }
  });

  // 키 이벤트 : keydown, keypress, keyup
  const keyboard = document.querySelector("#keyboard");
  const keyResult = document.querySelector("#keyResult");

  keyboard.addEventListener("keydown", (e) => {
    console.log(e.key);
    keyResult.textContent = e.key;
    if (e.key === "Enter") {
      alert("엔터!");
    }
  });

  const moveBox = document.querySelector(".moveBox");
  let x = 0;
  let y = 0;

  document.addEventListener("keydown", (e) => {
    if (e.key === "ArrowRight") x += 10;
    else if (e.key === "ArrowLeft") x -= 10;
    else if (e.key === "ArrowUp") y += 10;
    else if (e.key === "ArrowDown") y -= 10;

    // if (x < -11) x = -10;
    console.log("x좌표 : " + x);
    console.log("y좌표 : " + y);
    moveBox.style.left = `${x}px`;
    moveBox.style.bottom = `${y}px`;
  });

  const wheel = document.querySelector("#wheel");
  const scroll = document.querySelector("#scroll");
  // 스크롤 이벤트
  window.addEventListener("wheel", (e) => {
    //console.log(e.deltaY);
    // 휠을 올렸더니 -, 휠을 내렸더니 +
    if (e.deltaY < 0) wheel.textContent = "휠 위로 스크롤 중";
    else if (e.deltaY > 0) wheel.textContent = "휠 아래로 스크롤 중";
  });

  window.addEventListener("scroll", () => {
    // 전체 높이
    console.log("scrollHeight : " + document.documentElement.scrollHeight);
    // 보이는 화면 높이
    console.log("innerHeight : " + window.innerHeight);
    console.log("scrollY : " + window.scrollY);
    // scrollHeight === innerHeight + scrollY
    // scrollHeight - innerHeight : 스크롤 총 내리는 높이
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;
    const percent = (window.scrollY / totalHeight) * 100;
    console.log(percent);
  });
  window.addEventListener("scroll", (e) => {
    const totalHeight =
      document.documentElement.scrollHeight - window.innerHeight;
    const percent = (window.scrollY / totalHeight) * 100;

    scroll.style.width = `${percent}%`;
  });

  // 이벤트 위임
  // 이미지가 클릭될 떄마다 해당 이미지 지우기
  // 1. 이미지마다 이벤트 걸려면 반복문 필요
  const img = document.querySelectorAll(".container img");
  //   for (let i = 0; i < img.length; i++) {
  //     img[i].addEventListener("click", (e) => {
  //       //   img[i].style.display = "none";
  //       console.log(e.currentTarget);
  //       e.currentTarget.style.display = "none";
  //     });
  //   }

  // 2. 부모인 컨테이너에 이벤트 걸기
  const container = document.querySelector(".container");
  const removeHandler = (e) => {
    console.log("target : ", e.target); // 내가 클릭한 이미지
    console.log("currentTarget : ", e.currentTarget); // 이벤트 걸린 본인container
    if (e.target !== e.currentTarget) {
      e.target.style.display = "none";
    }
  };
  container.addEventListener("click", removeHandler);
});
