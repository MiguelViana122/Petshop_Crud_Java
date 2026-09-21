public class DadosMonitor implements DadosObserver {

    @Override
    public void dadosAlterados(String entidade, String acao) {
        System.out.println("[Observer] " + entidade + " " + acao + ".");
    }
}
