package br.com.caelum.livraria.bean;

import br.com.caelum.livraria.modelo.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class LoginBean {
	Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String efetuaLogin() {
		final FacesContext context = FacesContext.getCurrentInstance();
		if ("gleitonfranco@gmail.com".equals(usuario.getEmail())) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", usuario);
			System.out.println("Fazendo login");
			return "livro?faces-redirect=true";
		}
		context.addMessage(null, new FacesMessage("Usuário Não Encontrado!"));
		context.getExternalContext().getFlash().setKeepMessages(true);
		return "login?faces-redirect=true";
	}

	public String efetuarLogout() {
		final FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");
		return "login?faces-redirect=true";
	}

}
