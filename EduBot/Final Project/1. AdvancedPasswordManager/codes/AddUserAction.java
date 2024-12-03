import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AddUserAction extends Action {
    private DatabaseManager dbManager;

    public AddUserAction() {
        dbManager = new DatabaseManager();
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserForm userForm = (UserForm) form;
        String username = userForm.getUsername();
        dbManager.addUser(username);
        return mapping.findForward("success");
    }
}
