# github-actions-examples
Examples of Github Actions

# Introduction
Github Actions help you automate tasks.
They are declarative sets of instructions that are executed in response to events which happen on Github.

For example, you can create an Action which builds your project whenever a commit is pushed to Github.

Workflows are defined using YAML and have a structure like the following:

* Event that triggers this Action
  + Job 1
    - Step 1
      - Action
    - Step 2
      - Action
  + Job 2
    - Step 1
      - Action

Each Job is executed on a Runner, which is just some virtual machine running somewhere.
Github has Runners that you can use, and you can also self-host your own Runners.

Actions are, potentially reusable, commands that do specific things.
Github has lots of published Actions that you can make use of right away.
There are also many Actions which have been published by the community that you can use.

Here is an example of real Workflow:

```yaml
name: learn-github-actions
on: [push]
jobs:
  check-bats-version:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - uses: actions/setup-node@v1
      - run: npm install -g bats
      - run: bats -v
```

It is described in full, [here](https://docs.github.com/en/actions/learn-github-actions/introduction-to-github-actions#understanding-the-workflow-file).

When you specify an Action in your workflow, you need to provide the path to find the Action and its version.
Versions can be specified as `tags`, `branches`, or `SHAs`.