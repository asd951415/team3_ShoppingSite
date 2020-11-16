package kr.or.bit.service_ajax;

import com.google.gson.JsonObject;
import kr.or.bit.action.ActionAjax;
import kr.or.bit.action.ActionAjaxData;
import kr.or.bit.model.dao.DAOMember;
import kr.or.bit.model.dao.DAOSeller;
import kr.or.bit.model.dto.DTOMember;
import kr.or.bit.model.dto.DTOSeller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistSellerAjaxService implements ActionAjax {
    @Override
    public ActionAjaxData execute(HttpServletRequest request, HttpServletResponse response) {
        ActionAjaxData ajaxData = new ActionAjaxData();
        JsonObject body = (JsonObject) request.getAttribute("jsonBody");
        String id = body.get("id").getAsString();
        String pwd = body.get("pwd").getAsString();

        DTOMember dtoMember = DAOMember.getMemberById(id);
        DAOMember daoMember = new DAOMember();
        DAOSeller daoSeller = new DAOSeller();
        DTOSeller dtoSeller = new DTOSeller();
        if (dtoMember.getId() == id) {
            if (pwd == dtoMember.getPwd()) {

                daoSeller.lim_registSeller(dtoSeller);
                //sel_flag 'N' -> 'Y'
                daoMember.lim_RegistSeller(id);
                ajaxData.setData("success");

            }
        } else {
            ajaxData.setData("fail");

        }
        ajaxData.setContentType("text/plain");

        return ajaxData;
    }
}
