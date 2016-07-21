package mx.gob.sfp;

public final class SystemEnum {
	
	public enum SYSTEM_URLS{
		//URLS DE REDIRECCIONAMIENTO DE TODO EL SISTEMA
		PAGINA1			(1,"url.home.inicio");
		
		private int idURL;
		private String descripcion;

		private SYSTEM_URLS(int idURL, String opcion){
			this.idURL = idURL;
			this.descripcion = opcion;
		}

		public int getIdURL() {
			return idURL;
		}
		
		public String getDescripcion() {
			return descripcion;
		}

		public static String getDescripcion(int idURL){
			String descripcion = null;			
			for (SYSTEM_URLS tipo : SYSTEM_URLS.values()){
				if (tipo.getIdURL() == idURL){
					descripcion = tipo.getDescripcion();
					break;
				}
			}
			return descripcion;
		}
	}

}
