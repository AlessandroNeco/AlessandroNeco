document.addEventListener('DOMContentLoaded', () => {
    const searchBtn = document.getElementById('searchBtn');
    const codigoInput = document.getElementById('codigoInput');
    const loading = document.getElementById('loading');
    const error = document.getElementById('error');
    const result = document.getElementById('result');

    // Elementos de exibição de dados
    const productImage = document.getElementById('productImage');
    const productName = document.getElementById('productName');
    const productBrand = document.getElementById('productBrand');
    const productCategory = document.getElementById('productCategory');
    const productNcm = document.getElementById('productNcm');
    const productNcmDesc = document.getElementById('productNcmDesc');
    const productCest = document.getElementById('productCest');
    const productCestSeg = document.getElementById('productCestSeg');

    searchBtn.addEventListener('click', () => {
        const codigo = codigoInput.value.trim();

        if (!codigo) {
            showError('Por favor, digite um código de barras.');
            return;
        }

        buscarProduto(codigo);
    });

    codigoInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            searchBtn.click();
        }
    });

    async function buscarProduto(codigo) {
        // Reset do UI
        error.classList.add('hidden');
        result.classList.add('hidden');
        loading.classList.remove('hidden');

        try {
            const response = await fetch(`/api/consulta/${codigo}`);

            if (!response.ok) {
                if (response.status === 404) {
                    throw new Error('Produto não encontrado.');
                }
                throw new Error('Erro ao consultar o produto.');
            }

            const data = await response.json();
            exibirProduto(data);
        } catch (err) {
            showError(err.message);
        } finally {
            loading.classList.add('hidden');
        }
    }

    function exibirProduto(produto) {
        productImage.src = produto.imagem_url || '';
        productImage.style.display = produto.imagem_url ? 'block' : 'none';

        productName.textContent = produto.produto || 'N/A';
        productBrand.textContent = produto.marca || 'N/A';
        productCategory.textContent = produto.categoria || 'N/A';
        productNcm.textContent = produto.ncm || 'N/A';
        productNcmDesc.textContent = produto.ncm_descricao || 'N/A';
        productCest.textContent = produto.cest_codigo || 'N/A';
        productCestSeg.textContent = produto.cest_segmento || 'N/A';

        result.classList.remove('hidden');
    }

    function showError(message) {
        error.textContent = message;
        error.classList.remove('hidden');
        result.classList.add('hidden');
    }
});
