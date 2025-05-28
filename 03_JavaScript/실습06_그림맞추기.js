const click = document.querySelector("#click");
const restart = document.querySelector("#restart");
const imgContainer = document.querySelector("#imgContainer");
const imgs = document.querySelectorAll("#imgContainer img");
const celebration = document.querySelector("#celebration");

let clickCount = 0;

const changeImg = (e) => {
  for (let i = 0; i < imgs.length; i++) {
    let random = Math.floor(Math.random() * 3);
    imgs[i].setAttribute("src", `assets/spy${random + 1}.jpg`);
  }
  clickCount += 1;

  click.textContent = `Click ${clickCount}`;
  const img1 = imgs[0].getAttribute("src");
  const img2 = imgs[1].getAttribute("src");
  const img3 = imgs[2].getAttribute("src");

  if (img1 == img2 && img1 == img3) {
    celebration.textContent =
      "축하합니다! 다시 시작하려면 재시작 버튼을 눌러주세요";
    click.style.pointerEvents = "none";
  }
};

const restartGame = (e) => {
  for (let i = 0; i < imgs.length; i++) {
    imgs[i].setAttribute("src", `assets/spy${i + 1}.jpg`);
  }
  celebration.textContent = "";
  click.style.pointerEvents = "";
  click.textContent = "Click";
  clickCount = 0;
};

click.addEventListener("click", changeImg);

restart.addEventListener("click", restartGame);
