document.addEventListener('DOMContentLoaded', function () {
    // Sử dụng JavaScript
    document.querySelector('#favoriteButton').addEventListener('click', function () {
        var offcanvas = new bootstrap.Offcanvas(document.querySelector('#offcanvasFavorite'));
        offcanvas.toggle();
    });
});
