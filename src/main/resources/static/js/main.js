window.filterList = () => {
    let searchTerm = document.getElementById('searchTerm2').value;
    let customerRows = document.getElementsByClassName('customer-row');
    for (let row of customerRows) {
        if (row.innerText.indexOf(searchTerm) === -1) row.classList.add('hidden');
        else row.classList.remove('hidden');
    }
}