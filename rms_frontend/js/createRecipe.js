function addIngredient() {
    var myDiv = document.getElementById("ingredient-div");
    var myList = document.getElementById("ingredient-list");
    var newListItem = document.createElement("li");
    var newInput = document.createElement("input");
    var btnDelete = document.createElement("button");

    newInput.name = "ingredient";
    newInput.id = "ingredient";
    newInput.type = "text";

    btnDelete.type = "button";
    btnDelete.classList.add("btn-delete");
    btnDelete.innerText = "-";
    btnDelete.addEventListener("click", removeIngredientField);

    newListItem.appendChild(newInput);
    newListItem.appendChild(btnDelete);
    myList.appendChild(newListItem);
    myDiv.appendChild(myList);
}

function removeIngredientField(el) {
    const field = el.target.parentElement;
    field.remove();
}
