package com.bootcamp_2024.ms_stock.dominio.paginacion;

public class PaginacionImpl implements Paginacion {
    private final int pagina;
    private final int tamanio;
    private final Orden orden;

    public PaginacionImpl(int pagina, int tamanio, Orden orden) {
        this.pagina = pagina;
        this.tamanio = tamanio;
        this.orden = orden;
    }

    @Override
    public int getPagina() {
        return pagina;
    }

    @Override
    public int getTamanio() {
        return tamanio;
    }

    @Override
    public Orden getOrden() {
        return orden;
    }
}
