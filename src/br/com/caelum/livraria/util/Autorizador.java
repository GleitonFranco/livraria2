package br.com.caelum.livraria.util;

import br.com.caelum.livraria.modelo.Usuario;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class Autorizador implements PhaseListener {
    @Override
    public void afterPhase(PhaseEvent phaseEvent) {
        FacesContext context = phaseEvent.getFacesContext();
        String nomePagina = context.getViewRoot().getViewId();
        System.out.println(nomePagina);
        if ("/login.xhtml".equals(nomePagina)) {
            return;
        }
        Usuario usuario = (Usuario) context.getExternalContext().getSessionMap().get("usuarioLogado");
        if (usuario != null) {
            return;
        }
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "/login?faces-redirect=true");
        context.renderResponse();
    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

}
