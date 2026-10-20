import express from 'express';
import fetch from 'node-fetch';
import cors from 'cors';
import path from 'path';
import { fileURLToPath } from 'url';

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
const port = 3000;

app.use(cors());
app.use(express.static(path.join(__dirname, 'public')));

const token = process.env.API_TOKEN || "180|Qc1Ip26qiJuW3U6zetHeNS2n6ctclmI3pQUOTGZ69c761e59";

app.get('/api/consulta/:codigo', async (req, res) => {
    const { codigo } = req.params;
    try {
        const response = await fetch(`https://global.si5.com.br/api/produtos/${codigo}`, {
            headers: {
                "Authorization": `Bearer ${token}`,
                "Accept": "application/json"
            }
        });

        if (!response.ok) {
            return res.status(response.status).json({ error: 'Erro ao buscar o produto' });
        }

        const data = await response.json();
        res.json(data);
    } catch (error) {
        console.error(error);
        res.status(500).json({ error: 'Erro interno no servidor' });
    }
});

app.listen(port, () => {
    console.log(`Servidor rodando em http://localhost:${port}`);
});
