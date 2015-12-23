package github.jerneliu.webboilerplate.web;

import github.jerneliu.webboilerplate.domain.Todo;
import github.jerneliu.webboilerplate.domain.TodoRepository;
import github.jerneliu.webboilerplate.exception.ResourceNotFound;
import github.jerneliu.webboilerplate.common.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;

/**
 * Todos related Controller
 *
 * @author yu_jiong
 * @since 0.1
 */
@Controller
@RequestMapping("/todos")
public class TodosController extends ApplicationController {

    private final Logger logger = LoggerFactory.getLogger(TodosController.class);

    @Autowired
    private TodoRepository repository;

    /**
     * todo index
     */
    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("todos", repository.findAll());
        return "todos/index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable Integer id, Model model) {
        Todo todo = repository.findOne(id);
        if (todo == null) {
            throw new ResourceNotFound();
        }

        model.addAttribute(todo);
        return "todos/show";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable Integer id, Model model) {
        show(id, model);
        return "todos/edit";
    }

    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("id") @Valid Todo todo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "todos/edit";
        }
        repository.save(todo);

        toast(redirectAttributes, message(Consts.Messages.UPDATE_SUCCESSFULLY));
        UriComponents show = MvcUriComponentsBuilder
                .fromMethodName(TodosController.class, "show", todo.getId(), null).build();
        return "redirect:" + show.toUriString();
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newly(@ModelAttribute Todo todo) {
        return "todos/new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@ModelAttribute @Valid Todo todo, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "todos/new";
        }

        Todo savedTodo = repository.save(todo);
        toast(redirectAttributes, message(Consts.Messages.CREATE_SUCCESSFULLY));

        UriComponents show = MvcUriComponentsBuilder
                .fromMethodName(TodosController.class, "show", savedTodo.getId(), null).build();
        return "redirect:" + show.toUriString();
    }
}
