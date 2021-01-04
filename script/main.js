function setModal(obj) {
    const modal_inner = document.getElementById('modal_inner');
    modal_inner.innerHTML = `
        <img src="${obj.file_path}" alt="Image - ${obj.title}">
        <h2>${obj.title}</h2>
        <strong>${obj.author_name}</strong>
        <p>${obj.description}</p>
        <small>${obj.regdate}</small>
        <a href="${obj.file_path}" download>Download Image</a>
    `;
    // console.log(obj);
}


function hideModal(e) {
    if (e.target == modal) {
        modal.classList.remove('show');
        btntop.classList.remove('show');
    }
}

function showModal() {
    modal.classList.add('show');
    btntop.classList.add('show');
}

function createEl(obj) {
    const el = document.createElement('a');
    el.className = 'item';
    el.innerHTML = `
        <img src="${obj.file_path}" alt="open modal - ${obj.title}">
            <div>
                <strong>${obj.title}</strong>
                <small>${obj.author_name}</small>
            </div>`;


    // console.log(el);

    // el.onclick = setModal;

    el.onclick = function () {
        setModal(obj);
        showModal();
    }

    return el;
}

function init() {
    const container = document.getElementById('container');
    axios.get('./data.json')
        .then(function (res) {
            res.data.forEach(function (obj) {
                container.append(createEl(obj));
            })
        })

    const modal = document.getElementById('modal');
    const btntop = document.getElementById('btntop');
    modal.onclick = hideModal;
}

init();
