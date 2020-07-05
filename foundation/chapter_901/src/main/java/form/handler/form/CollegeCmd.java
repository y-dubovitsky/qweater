package form.handler.form;

import form.handler.model.College;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CollegeCmd {

    private List<College> collegeList;

    public CollegeCmd() {
        collegeList = List.of(
                new College(123, "sdf"),
                new College(125463, "35")
                );
    }

    public List<College> getCollegeList() {
        return collegeList;
    }

    public void setCollegeList(List<College> collegeList) {
        this.collegeList = collegeList;
    }
}
