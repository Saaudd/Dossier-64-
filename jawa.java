// Fungsi untuk mengganti halaman
function showPage(pageId) {
    // Sembunyikan semua halaman
    const pages = document.querySelectorAll('.page');
    pages.forEach(page => {
        page.classList.remove('active-page');
    });
    
    // Tampilkan halaman yang dipilih
    const activePage = document.getElementById(`page-${pageId}`);
    if (activePage) {
        activePage.classList.add('active-page');
    }
    
    // Update active class di navbar
    const navLinks = document.querySelectorAll('.nav-menu li a');
    navLinks.forEach(link => {
        link.classList.remove('active');
    });
    
    const activeLink = document.getElementById(`nav-${pageId}`);
    if (activeLink) {
        activeLink.classList.add('active');
    }
}

// Fungsi untuk membuka detail dokumen
function revealDetail(detailId) {
    const detailElement = document.getElementById(detailId);
    if (detailElement) {
        detailElement.classList.toggle('hidden');
        
        // Ganti teks tombol
        const button = event.target;
        if (detailElement.classList.contains('hidden')) {
            button.textContent = 'BUKA DOKUMEN';
        } else {
            button.textContent = 'TUTUP DOKUMEN';
            
            // Tampilkan modal peringatan pertama kali
            if (!localStorage.getItem('warningShown')) {
                showModal();
                localStorage.setItem('warningShown', 'true');
            }
        }
    }
}

// Fungsi modal
function showModal() {
    const modal = document.getElementById('secretModal');
    if (modal) {
        modal.style.display = 'block';
    }
}

function closeModal() {
    const modal = document.getElementById('secretModal');
    if (modal) {
        modal.style.display = 'none';
    }
}

// Close modal jika klik di luar
window.onclick = function(event) {
    const modal = document.getElementById('secretModal');
    if (event.target == modal) {
        modal.style.display = 'none';
    }
}

// Set default halaman
document.addEventListener('DOMContentLoaded', function() {
    showPage('beranda');
});

// Export functions
window.showPage = showPage;
window.revealDetail = revealDetail;
window.closeModal = closeModal;