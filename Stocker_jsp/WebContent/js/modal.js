function setModal(data) {
    const modal_inner = document.getElementById('modal_inner');

    modal_inner.innerHTML = `
		<img alt="Open modal - Image ${data.title}" src="/images/${data.file_nm}">
		<h3>${data.title}</h3>
		<p><strong>${data.author_nm}</strong></p>
		<p>${data.caption}</p>
		<p><small>${data.regdate}</small></p>
		<a href="/images/${data.file_nm}" download>Download Image</a>
	`;

}

function toggleModal() {
    const modal = document.getElementById('modal');
    modal.classList.toggle('hide');
}

function init() {
    const modal = document.getElementById('modal');
    modal.addEventListener('click', function (e) {
        if (e.target == this) { toggleModal(); }
    })

    const item_list = document.querySelectorAll('.item');
    item_list.forEach(function (item) {
        item.addEventListener('click', function () {
            const id = this.dataset.id;

            fetch('/article?id=' + id)
                .then(function (res) {
                    // console.log(res.json);
                    return res.json()
                })
                .then(data => {
                    console.log(data);
                    setModal(data);
                    toggleModal();
                })

        })

    })
}

init();