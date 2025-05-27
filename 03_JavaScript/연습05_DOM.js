// 1번 문제
function printText() {
  const result1 = document.querySelector("#result1");
  result1.textContent = "텍스트출력 완";
}

// 2번 문제
const result2 = document.querySelector("#result2");
const customer = document.querySelector("#customer");
function printInputValue() {
  result2.textContent = "input 값 : " + customer.value;
  // input값 비우기
  customer.value = null;
}

// 3번 문제
const divTest = document.querySelector(".div-test");
function changeColor() {
  divTest.style.backgroundColor = "blue";
}

// 4번 문제
const result4 = document.querySelector("#result4");
const text = document.querySelector("#text");
function stringLength() {
  const textLength = text.value.length;
  result4.textContent = "문자열 길이 : " + textLength;
}

// 5번 문제
const result5 = document.querySelector("#result5");
const la = document.querySelector("#la");
function stringSplit() {
  const laArr = la.textContent.split(", ");
  const ul = document.createElement("ul");
  result5.appendChild(ul);

  for (let i = 0; i < laArr.length; i++) {
    const li = document.createElement("li");
    li.textContent = laArr[i];
    ul.appendChild(li);
    //ul.innerHTML += `<li>${laArr[i]}</li>`;
  }
}

// 6번 문제
// let array = ["피자", "치킨", "떡볶이"];
const result6 = document.querySelector("#result6");
const remove = document.querySelector("#remove");
const add = document.querySelector("#add");
const preview = document.querySelector("#preview");
const preArr = preview.textContent.split(" ");
function arrayTest() {
  //   for (let i = 0; i < preArr.length; i++) {
  //     preArr.splice(i, 1);
  //   }
  if (add.value) preArr.push(add.value);
  if (remove.value) {
    if (preArr.indexOf(remove.value) != -1)
      //preArr.includes(remove.value) == true
      preArr.splice(preArr.indexOf(remove.value), 1);
  }
  //   console.log(array.join(","));
  add.value = "";
  remove.value = "";

  preview.textContent = preArr.join(" ");
}

// 7번 문제 : prompt로 이름, 나이, 주소 순으로 입력받아서 출력
//const clName = document.getElementsByClassName("name");
const clName = document.querySelectorAll(".name");
//const clAge = document.getElementsByClassName("age");
const clAge = document.querySelectorAll(".age");
//const clAddr = document.getElementsByClassName("addr");
const clAddr = document.querySelectorAll(".addr");
function addStudent() {
  for (let i = 0; i < clName.length; i++) {
    const name = prompt(`${i + 1}번째 이름을 입력해 주세요`);
    clName[i].textContent = name;
    const age = prompt(`${i + 1}번째 나이를 입력해 주세요`);
    clAge[i].textContent = age;
    const addr = prompt(`${i + 1}번째 주소를 입력해 주세요`);
    clAddr[i].textContent = addr;
  }
}

// 8번
const ul = document.querySelector("#list");
function addItem() {
  const li = document.createElement("li");
  li.textContent = "test";
  // li 태그를 만들어서 추가하는 방식
  ul.appendChild(li);

  // innerHTML로 문자로 추가하는 방식
  // ul.innerHTML += <li>test</li>
}
function removeItem() {
  // 부모에서 제거
  // ul.removeChild(ul.childNodes[0]);

  // 본인이 제거
  const li = document.querySelector("#list li");
  if (li) li.remove();
}

// 9번
function toggleClass() {
  const div = document.querySelector("#result9");

  div.classList.toggle("active");
}

// 10번
let totalPrice = 0;
const item = document.querySelector("#item");
const price = document.querySelector("#price");
const cart = document.querySelector("#cart");
const total = document.querySelector("#total span");
function addToCart() {
  const list = document.createElement("li");
  console.log(isNaN(Number(price.value)));
  if (item.value && price.value) {
    if (!isNaN(Number(price.value))) {
      list.textContent = `${item.value} - ${price.value}원`;
      cart.appendChild(list);
      totalPrice += Number(price.value);
      total.textContent = totalPrice;
    }
  }

  item.value = "";
  price.value = "";
}
