const PROXY_CONFIG = [
  {
    context: ["/api"],
    target: "http://localhost:8080/", // Altere o target para a URL do seu backend
    secure: false, // Define se o proxy deve verificar a segurança (usado para HTTPS)
    logLevel: "debug", // Define o nível de log (útil para depuração)
  },
];

module.exports = PROXY_CONFIG;
