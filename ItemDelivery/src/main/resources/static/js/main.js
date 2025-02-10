document.addEventListener("DOMContentLoaded", function() {
    // Spinner
    var spinner = document.getElementById('spinner');
    if (spinner) {
        setTimeout(function() {
            spinner.classList.remove('show');
        }, 1000);
    }

    // Back to top button
    var backToTop = document.querySelector('.back-to-top');
    window.addEventListener('scroll', function() {
        if (window.scrollY > 100) {
            backToTop.style.display = 'block';
        } else {
            backToTop.style.display = 'none';
        }
    });

    backToTop.addEventListener('click', function(e) {
        e.preventDefault();
        window.scrollTo({ top: 0, behavior: 'smooth' });
    });
});