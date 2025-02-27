
document.addEventListener("DOMContentLoaded", () => {
    const searchIcon = document.getElementById("searchIcon");
    const searchBar = document.getElementById("searchBar");

    searchIcon.addEventListener("click", () => {
        searchBar.classList.toggle("active");
        if (searchBar.classList.contains("active")) {
            searchBar.focus();
        }
    });

    document.addEventListener("click", (event) => {
        if (!searchIcon.contains(event.target) && !searchBar.contains(event.target)) {
            searchBar.classList.remove("active");
        }
    });
});




  function toggleFields() {
    const userType = document.getElementById('userType').value;
    const organizationFields = document.getElementById('organizationFields');
    const commonFields = document.getElementById('commonFields');
    if (userType === 'organization') {
      organizationFields.style.display = 'block';
      commonFields.style.display = 'none'; // Hide common fields for individuals
    } else {
      organizationFields.style.display = 'none';
      commonFields.style.display = 'block'; // Show common fields for individuals
    }
  }





