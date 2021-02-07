// When the Add button is clicked, first you need to validate the inputs. If any of the input fields is invalid (empty or default value), 
// the function doesn’t make anything. Be careful with the validation of the Module dropdown (it's default value is NOT an empty string). 
// After validating the input fields, you need to add the new lecture in the Trainings section. 

// The added lecture should have button with text "Del".  The date and the lecture name must be formatted as shown on the screenshots. 
// Be careful with the HTML-Structure and with the class names!

// If there is another Lecture with the same Module:
// The lectures should be sorted by DATE! The date is separated with slashes (/) and the separator between the date and time is a minus sign.
// Hint: The format of the date allows alphabetical sort.

// When the “Delete” button is clicked, the Lecture (whole list element) should be removed from the HTML. 
// If there are NO Lectures left in the module (after delete) the whole module should be also deleted.

function solve() {
  let addButtonElement = document.querySelector(".form-control button");
  let modulesElement = document.querySelector(".modules");

  let [lectureNameElement, dateElement] = Array.from(
    document.querySelectorAll("input")
  );
  let moduleElement = document.querySelector('select[name="lecture-module"]');

  let modulesObj = {};

  function moduleExists() {
    return modulesObj.hasOwnProperty([moduleElement.value]);
  }

  addButtonElement.addEventListener("click", (e) => {
    e.preventDefault();

    if (
      !lectureNameElement.value ||
      !dateElement.value ||
      moduleElement.value === "Select module"
    ) {
      return;
    }

    let date = dateElement.value.replace(/-/g, "/").replace("T", " - ");

    if (!moduleExists()) {
      modulesObj[moduleElement.value] = [];
    }
    modulesObj[moduleElement.value].push({
      lectureName: lectureNameElement.value,
      date: date,
    });

    document.querySelector(".modules").innerHTML = "";
    Object.keys(modulesObj).forEach((module) => {
      modulesObj[module].sort((a, b) => a.date.localeCompare(b.date));

      let h3ModuleElement = document.createElement("h3");
      h3ModuleElement.innerText = `${module.toUpperCase()}-MODULE`;

      let ulElement = document.createElement("ul");

      modulesObj[module].forEach((lectureObj) => {
        let liElement = document.createElement("li");
        liElement.setAttribute("class", "flex");

        let h4Element = document.createElement("h4");
        h4Element.innerText = `${lectureObj.lectureName} - ${lectureObj.date}`;

        liElement.appendChild(h4Element);

        let delElement = document.createElement("button");
        delElement.setAttribute("class", "red");
        delElement.innerText = "Del";

        delElement.addEventListener("click", (e) => {
          if (modulesObj[module].length == 1) {
            e.target.parentElement.parentElement.parentElement.remove();
            delete modulesObj[module];
          } else {
            e.target.parentElement.remove();
            modulesObj[module].shift();
          }
        });

        liElement.appendChild(delElement);
        ulElement.appendChild(liElement);
      });

      let moduleDivElement = document.createElement("div");
      moduleDivElement.setAttribute("class", "module");

      moduleDivElement.appendChild(h3ModuleElement);
      moduleDivElement.appendChild(ulElement);

      modulesElement.appendChild(moduleDivElement);
    });

    lectureNameElement.value = "";
    dateElement.value = "";
    moduleElement.value = "Select module";
  });
}
