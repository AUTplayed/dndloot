$$(".op").forEach(op => {
    op.onclick = ev => {
        const isAdd = ev.srcElement.classList.contains("add")
        const $count = ev.srcElement.parentNode.querySelector(".count")
        $count.value = isAdd ? parseInt($count.value) + 1 : parseInt($count.value) - 1
    }
})

function collectInput() {
    const json = {};
    for (const counter of $$(".count")) {
        const rarity = counter.parentNode.parentNode.querySelector(".name").innerHTML;
        const count = parseInt(counter.value)
        json[rarity] = count;
    }
    return json;
}

$("#roll").onclick = () => {
    const data = collectInput();
    var url = "";
    for (const rarity in data) {
        if (data[rarity] > 0) {
            url += `${rarity}=${data[rarity]}&`
        }
    }
    ldf.nav("/roll?" + url.substring(0, url.length - 1));
}