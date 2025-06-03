let idRegExp = /^[a-zA-Z][a-zA-Z0-9]{3,11}$/;
let pwRegExp =
  /^(?=.*[A-Za-z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,15}$/;
let nameRegExp = /^[가-힣]{2,}$/;
let emailRegExp = /^[\w.-]+@[\w.-]+\.[A-Za-z]{2,}$/;
let phoneRegExp = /^010-\d{4}-\d{4}$/;

let check1 = false; //idInput
let check2 = false; //pwInput
let check3 = false; //pwCheck
let check4 = false; //userName
let check5 = false; //email
let check6 = false; //phone

const idInput = document.querySelector("#idInput");
const idSpan = document.querySelector("#idInput+span");
const pwInput = document.querySelector("#pwInput");
const pwSpan = document.querySelector("#pwInput+span");
const pwCheck = document.querySelector("#pwCheck");
const pwCheckSpan = document.querySelector("#pwCheck+span");
const userName = document.querySelector("#userName");
const userNameSpan = document.querySelector("#userName+span");
const email = document.querySelector("#email");
const emailSpan = document.querySelector("#email+span");
const phone = document.querySelector("#phone");
const phoneSpan = document.querySelector("#phone+span");
const cancel = document.querySelector("#cancel");
const signup = document.querySelector("#signup");

idInput.addEventListener("input", (e) => {
  if (idRegExp.test(e.target.value)) {
    idSpan.textContent = "OK!";
    idSpan.style.color = "green";
    check1 = true;
  } else if (e.target.value === "") {
    idSpan.textContent = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    idSpan.style.color = "black";
    check1 = false;
  } else {
    idSpan.textContent = "영문자로 시작하고 영문자와 숫자 조합으로 4~12자 이내";
    idSpan.style.color = "red";
    check1 = false;
  }

  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

pwInput.addEventListener("input", (e) => {
  if (pwRegExp.test(e.target.value)) {
    pwSpan.textContent = "OK!";
    pwSpan.style.color = "green";
    check2 = true;
  } else if (e.target.value === "") {
    pwSpan.textContent = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    pwSpan.style.color = "black";
    check2 = false;
  } else {
    pwSpan.textContent = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
    pwSpan.style.color = "red";
    check2 = false;
    pwCheckSpan.textContent = "위와 동일한 비밀번호를 입력해주세요";
    pwCheckSpan.style.color = "red";
    check3 = false;
  }

  if (pwCheck.value !== "") {
    if (e.target.value !== pwCheck.value) {
      pwCheckSpan.textContent = "위와 동일한 비밀번호를 입력해주세요";
      pwCheckSpan.style.color = "red";
      check3 = false;
    }
    if (e.target.value === pwCheck.value) {
      pwCheckSpan.textContent = "OK!";
      pwCheckSpan.style.color = "green";
      check3 = true;
    }
  } else {
    pwCheckSpan.style.color = "black";
    check3 = false;
  }

  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

pwCheck.addEventListener("input", (e) => {
  if (e.target.value === pwInput.value) {
    pwCheckSpan.textContent = "OK!";
    pwCheckSpan.style.color = "green";
    check3 = true;
  } else {
    pwCheckSpan.textContent = "위와 동일한 비밀번호를 입력해주세요";
    pwCheckSpan.style.color = "red";
    check3 = false;
  }
  if (e.target.value === "") {
    pwCheckSpan.textContent = "위와 동일한 비밀번호를 입력해주세요";
    pwCheckSpan.style.color = "black";
    check3 = false;
  }

  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

userName.addEventListener("input", (e) => {
  if (nameRegExp.test(e.target.value)) {
    userNameSpan.textContent = "OK!";
    userNameSpan.style.color = "green";
    check4 = true;
  } else if (e.target.value === "") {
    userNameSpan.textContent = "한글 2자 이상";
    userNameSpan.style.color = "black";
    check4 = false;
  } else {
    userNameSpan.textContent = "한글 2자 이상";
    userNameSpan.style.color = "red";
    check4 = false;
  }

  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

email.addEventListener("input", (e) => {
  if (emailRegExp.test(e.target.value)) {
    emailSpan.textContent = "OK!";
    emailSpan.style.color = "green";
    check5 = true;
  } else if (e.target.value === "") {
    emailSpan.textContent = "이메일 형식";
    emailSpan.style.color = "black";
    check5 = false;
  } else {
    emailSpan.textContent = "이메일 형식";
    emailSpan.style.color = "red";
    check5 = false;
  }

  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

phone.addEventListener("input", (e) => {
  if (phoneRegExp.test(e.target.value)) {
    phoneSpan.textContent = "OK!";
    phoneSpan.style.color = "green";
    check6 = true;
  } else if (e.target.value === "") {
    phoneSpan.textContent = "한글 2자 이상";
    phoneSpan.style.color = "black";
    check6 = false;
  } else {
    phoneSpan.textContent = "한글 2자 이상";
    phoneSpan.style.color = "red";
    check6 = false;
  }

  signup.disabled = !(check1 && check2 && check3 && check4 && check5 && check6);
});

cancel.addEventListener("click", () => {
  pwSpan.textContent = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
  pwSpan.style.color = "black";
  pwSpan.textContent = "영문자, 숫자, 특수문자 조합으로 8~15자 이내";
  pwSpan.style.color = "black";
  pwCheckSpan.textContent = "위와 동일한 비밀번호를 입력해주세요";
  pwCheckSpan.style.color = "black";
  userNameSpan.textContent = "한글 2자 이상";
  userNameSpan.style.color = "black";
  emailSpan.textContent = "이메일 형식";
  emailSpan.style.color = "black";
  phoneSpan.textContent = "한글 2자 이상";
  phoneSpan.style.color = "black";
});
