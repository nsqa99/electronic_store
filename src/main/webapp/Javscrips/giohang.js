const removeBtn = document.querySelectorAll("#removeBtn");
const addBtn = document.querySelectorAll("#addBtn");
const subBtn = document.querySelectorAll("#subBtn");
const totalCost = document.querySelector("#totalCost");
const itemCosts = document.querySelectorAll("#itemCost");

const totalCostCalculate = () => {
  let newTotal = 0;
  for (let i = 0; i < itemCosts.length; i++) {
    newTotal += parseFloat(itemCosts[i].innerHTML);
  }
  totalCost.innerHTML = newTotal.toFixed(0);
};

window.onload = totalCostCalculate();

for (let i = 0; i < removeBtn.length; i++) {
  let button = removeBtn[i];
  button.addEventListener("click", () => {
    console.log("remove");
    button.parentElement.setAttribute("id", "invisible");
    let cost = button.parentElement.querySelector("#itemCost");
    cost.innerHTML = "0 VND";
    totalCostCalculate();
  });
}

for (let i = 0; i < addBtn.length; i++) {
  let button = addBtn[i];
  button.addEventListener("click", (e) => {
    e.preventDefault();
    console.log("add");
    let quantity = button.parentElement.querySelector("#itemQuantity");
    let cost = button.parentElement.parentElement.querySelector("#itemCost");
    // console.log(cost);
    let costBefore = parseFloat(cost.innerHTML.split(" VND")[0]);
    console.log(costBefore);

    let costPerItem = parseFloat(costBefore) / parseFloat(quantity.innerHTML);

    let newCost = costBefore + costPerItem;

    quantity.innerHTML = parseInt(quantity.innerHTML) + 1;
    cost.innerHTML = newCost.toFixed(0) + " VND";
    totalCostCalculate();
  });
}

for (let i = 0; i < subBtn.length; i++) {
  let button = subBtn[i];
  button.addEventListener("click", (e) => {
    e.preventDefault();
    console.log("sub");
    let quantity = button.parentElement.querySelector("#itemQuantity");
    let cost = button.parentElement.parentElement.querySelector("#itemCost");
    // console.log(cost);
    let costBefore = parseInt(cost.innerHTML.split(" VND")[0]);

    let costPerItem = parseFloat(costBefore) / parseFloat(quantity.innerHTML);

    let newCost = costBefore - costPerItem;

    if (quantity.innerHTML == 1) return;
    quantity.innerHTML = parseInt(quantity.innerHTML) - 1;

    cost.innerHTML = newCost.toFixed(0) + " VND";
    totalCostCalculate();
  });
}
